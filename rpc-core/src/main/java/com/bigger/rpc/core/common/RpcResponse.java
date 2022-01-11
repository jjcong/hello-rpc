package com.bigger.rpc.core.common;

import lombok.Data;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
@Data
public class RpcResponse {

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 返回信息
     */
    private String message;

}
