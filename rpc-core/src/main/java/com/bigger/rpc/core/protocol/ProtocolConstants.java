package com.bigger.rpc.core.protocol;

/**
 * @Author: changjiu.wang
 * @Date: 2021/7/24 22:58
 */
public class ProtocolConstants {


    /**
     * 消息头总长度
     */
    public static final int HEADER_TOTAL_LEN = 42;

    /**
     * 魔数
     */
    public static final short MAGIC = 0x00;

    /**
     * 版本号
     */
    public static final byte VERSION = 0x1;

    /**
     * 请求长度
     */
    public static final int REQ_LEN = 32;

}
