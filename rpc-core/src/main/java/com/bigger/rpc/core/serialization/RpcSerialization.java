package com.bigger.rpc.core.serialization;

import java.io.IOException;

/**
 * PRC 序列化接口
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public interface RpcSerialization {


    /**
     * 序列化
     * @param obj
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T obj) throws IOException;


    /**
     * 反序列化
     * @param data
     * @param clz
     * @param <T>
     * @throws IOException
     */
    <T>  T deserialize(byte[] data, Class<T> clz) throws IOException;
}
