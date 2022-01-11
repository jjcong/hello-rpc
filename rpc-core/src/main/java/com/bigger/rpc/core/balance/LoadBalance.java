package com.bigger.rpc.core.balance;

import com.bigger.rpc.core.common.ServiceInfo;

import java.util.List;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public interface LoadBalance {

    /**
     * 获取服务
     * @param serviceInfos 服务列表
     * @return 选定的服务
     */
    ServiceInfo chooseOne(List<ServiceInfo> serviceInfos);
}
