package com.bigger.rpc.core.balance;

import com.bigger.rpc.core.common.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机算法
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public class RandomBalance implements LoadBalance {

    private static Logger logger = LoggerFactory.getLogger(RandomBalance.class);

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    @Override
    public ServiceInfo chooseOne(List<ServiceInfo> serviceInfos) {

        return serviceInfos.get(RANDOM.nextInt(serviceInfos.size()));
    }
}
