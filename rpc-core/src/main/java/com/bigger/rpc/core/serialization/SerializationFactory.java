package com.bigger.rpc.core.serialization;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public class SerializationFactory {

    public static RpcSerialization getRpcSerialization(SerializationTypeEnum typeEnum) {
        switch (typeEnum) {
            case HESSIAN:
                return new HessianSerialization();
            case JSON:
                return new JsonSerialization();
            default:
                throw new IllegalStateException("serialization type is illegal");
        }
    }
}
