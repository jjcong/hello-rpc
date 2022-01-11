package com.bigger.rpc.core.balance;

import com.bigger.rpc.core.common.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * 轮询算法
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public class FullRoundBalance implements LoadBalance {

    private static Logger logger = LoggerFactory.getLogger(FullRoundBalance.class);

    private int index;

    @Override
    public ServiceInfo chooseOne(List<ServiceInfo> serviceInfos) {

        if (index >= serviceInfos.size()) {
            index = 0;
        }
        return serviceInfos.get(index++);
    }
}
