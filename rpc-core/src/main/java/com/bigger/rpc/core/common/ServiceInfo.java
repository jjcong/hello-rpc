package com.bigger.rpc.core.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
@Data
public class ServiceInfo implements Serializable {

    /**
     * 应用名称
     */
    private String appName;

    /**
     * 服务名称
     */
    private String serviceName;

    /**
     * 版本号
     */
    private String version;

    /**
     * 地址
     */
    private String address;


    /**
     * 端口
     */
    private String port;


}
