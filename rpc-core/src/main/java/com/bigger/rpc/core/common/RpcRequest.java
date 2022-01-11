package com.bigger.rpc.core.common;

import lombok.Data;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
@Data
public class RpcRequest {

    /**
     * 请求的服务名 + 版本
     */
    private String serviceName;

    /**
     * 请求调用的方法名
     */
    private String methodName;

    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;

    /**
     * 参数
     */
    private Object[] parameters;
}
