package com.bigger.rpc.core.discovery;

import com.bigger.rpc.core.common.ServiceInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.curator.x.discovery.ServiceDiscovery;

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


    @Override
    public ServiceInfo discovery(String serviceName) throws Exception {
        return null;
    }
}
