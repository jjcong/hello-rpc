package com.bigger.rpc.core.discovery;

import com.bigger.rpc.core.balance.LoadBalance;
import com.bigger.rpc.core.common.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.x.discovery.ServiceDiscovery;
import org.apache.curator.x.discovery.ServiceDiscoveryBuilder;
import org.apache.curator.x.discovery.ServiceInstance;
import org.apache.curator.x.discovery.details.JsonInstanceSerializer;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
@Slf4j
public class ZookeeperDiscoveryService implements DiscoveryService {

    /**
     * 超时时间
     */
    public static final int BASE_SLEEP_TIME_MS = 1000;

    /**
     * 重试次数
     */
    public static final int MAX_RETRIES = 3;

    /**
     * zookeeper根路径
     */
    public static final String ZK_BASE_PATH = "/demo_rpc";


    private ServiceDiscovery<ServiceInfo> serviceDiscovery;


    private LoadBalance loadBalance;

    public ZookeeperDiscoveryService(String registryAddr, LoadBalance loadBalance) {
        this.loadBalance = loadBalance;

        try {
            CuratorFramework client = CuratorFrameworkFactory.newClient(registryAddr,
                    new ExponentialBackoffRetry(BASE_SLEEP_TIME_MS, MAX_RETRIES));
            client.start();
            JsonInstanceSerializer<ServiceInfo> serializer = new JsonInstanceSerializer<>(ServiceInfo.class);
            this.serviceDiscovery = ServiceDiscoveryBuilder.builder(ServiceInfo.class)
                    .client(client)
                    .serializer(serializer)
                    .build();
            this.serviceDiscovery.start();
        } catch (Exception e) {
            log.error("serviceDiscovery start error :{}", e);
        }

    }


    @Override
    public ServiceInfo discovery(String serviceName) throws Exception {
        Collection<ServiceInstance<ServiceInfo>> serviceInstances = serviceDiscovery.queryForInstances(serviceName);

        if (CollectionUtils.isEmpty(serviceInstances) ) {
            return null;
        }

        return loadBalance.chooseOne(serviceInstances.stream().map(ServiceInstance::getPayload).collect(Collectors.toList()));
    }
}
