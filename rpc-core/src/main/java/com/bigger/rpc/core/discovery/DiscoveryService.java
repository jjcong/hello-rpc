package com.bigger.rpc.core.discovery;

import com.bigger.rpc.core.common.ServiceInfo;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public interface DiscoveryService {


    /**
     * 服务发现
     * @param serviceName 服务名称
     * @return  服务详情信息
     * @throws Exception
     */
    ServiceInfo discovery(String serviceName) throws Exception;
}
