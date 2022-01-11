package com.bigger.rpc.core.serialization;

import lombok.Getter;

/**
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public enum SerializationTypeEnum {


    /**
     * HESSIAN 序列化
     */
    HESSIAN((byte) 0),


    /**
     * JSON 序列化
     */
    JSON((byte) 1);

    @Getter
    private byte type;


    SerializationTypeEnum(byte type) {
        this.type = type;
    }


    public static SerializationTypeEnum parseByName(String typeName) {
        for (SerializationTypeEnum typeEnum : SerializationTypeEnum.values()) {
            if (typeEnum.name().equalsIgnoreCase(typeName)) {
                return typeEnum;
            }
        }
        return HESSIAN;
    }

    public static SerializationTypeEnum parseByType(byte type) {
        for (SerializationTypeEnum typeEnum : SerializationTypeEnum.values()) {
            if (typeEnum.getType() == type) {
                return typeEnum;
            }
        }
        return HESSIAN;
    }
}
