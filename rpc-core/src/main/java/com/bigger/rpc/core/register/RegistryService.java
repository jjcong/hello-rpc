package com.bigger.rpc.core.register;

import com.bigger.rpc.core.common.ServiceInfo;

import java.io.IOException;

/**、
 * 服务注册接口
 * @author j_cong
 * @version V1.0
 * @date 2022/1/11
 */
public interface RegistryService {


    void register(ServiceInfo serviceInfo) throws Exception;


    void unRegister(ServiceInfo serviceInfo) throws Exception;


    void destory() throws IOException;
}
