package com.bigger.rpc.core.register;

import com.bigger.rpc.core.common.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;

import java.io.IOException;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
@Slf4j
public class ZookeeperRegistryService implements RegistryService{


    private static final int BASE_SLEEP_TIME_MS = 1_000;

    private static final int MAX_RETRYS = 3;

    private static final String ZK_BASE_PATH = "/demo_rpc";


    private ServiceDiscovery<ServiceInfo> serviceDiscovery;


    public ZookeeperRegistryService(String registryAddr) {
        try {
            CuratorFramework client = CuratorFrameworkFactory.newClient(registryAddr, new ExponentialBackoffRetry(BASE_SLEEP_TIME_MS, MAX_RETRYS));
            client.start();
            JsonInstanceSerializer<ServiceInfo> serializer = new JsonInstanceSerializer<>(ServiceInfo.class);
            this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceInfo.class)
                    .client(client)
                    .serializer(serializer)
                    .basePath(ZK_BASE_PATH)
                    .build();
            this.serviceDiscovery.start();
        }catch (Exception e) {
            log.error("serviceDiscovery start error :{}", e);
        }
    }


    @Override
    public void register(ServiceInfo serviceInfo) throws Exception {
        ServiceInstance<ServiceInfo> serviceInstance = ServiceInstance.<ServiceInfo>builder()
                .name(serviceInfo.getServiceName())
                .address(serviceInfo.getAddress())
                .port(serviceInfo.getPort())
                .payload(serviceInfo)
                .build();

        serviceDiscovery.registerService(serviceInstance);

    }

    @Override
    public void unRegister(ServiceInfo serviceInfo) throws Exception {
        ServiceInstance<ServiceInfo> serviceInstance = ServiceInstance
                .<ServiceInfo>builder()
                .name(serviceInfo.getServiceName())
                .address(serviceInfo.getAddress())
                .port(serviceInfo.getPort())
                .payload(serviceInfo)
                .build();
        serviceDiscovery.unregisterService(serviceInstance);
    }

    @Override
    public void destory() throws IOException {
        serviceDiscovery.close();
    }
}
