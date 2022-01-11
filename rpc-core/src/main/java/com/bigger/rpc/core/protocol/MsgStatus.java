package com.bigger.rpc.core.protocol;

import lombok.Getter;
/**
 * @Classname MsgStatus
 * @Description 请求状态
 * @Date 2021/7/23 15:33
 * @Created by wangchangjiu
 */
public enum MsgStatus {
    /**
     * 成功
     */
    SUCCESS((byte)0),

    /**
     * 失败
     */
    FAIL((byte)1);

    @Getter
    private final byte code;

    MsgStatus(byte code) {
        this.code = code;
    }

    public static boolean isSuccess(byte code){
        return MsgStatus.SUCCESS.code == code;
    }

}
