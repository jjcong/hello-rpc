package com.bigger.rpc.core.common;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public class ServiceUtil {

    /**
     * 获取服务KEY
     * @param serviceName 服务名称
     * @param version 版本号
     * @return 服务唯一key
     */
    public static String serviceKey(String serviceName, String version) {
        return String.join("-", serviceName, version);
    }
}
