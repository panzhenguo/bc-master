package com.bjttsf.rpc;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;

import com.bjttsf.rpc.hystrix.UserServiceApiFallbackFactory;
import com.bjttsf.user.provider.api.service.UserInfoServiceApi;

@Component
@FeignClient(name="bc-provider-user",fallbackFactory=UserServiceApiFallbackFactory.class)
public interface UserServiceApiRpc extends UserInfoServiceApi{

}
