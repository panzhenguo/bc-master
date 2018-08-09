package com.bjttsf.rpc.hystrix;

import org.springframework.stereotype.Component;

import com.bjttsf.core.Result;
import com.bjttsf.rpc.UserServiceApiRpc;
import com.bjttsf.support.FallbackFactoryBase;
import com.bjttsf.user.model.domain.UserInfo;
import com.bjttsf.user.model.vo.UserInfoVo;

import feign.hystrix.FallbackFactory;
/**
 * 用户rpc 熔断
* @Title: UserServiceApiFallbackFactory.java  
* @Package com.bjttsf.rpc.hystrix
* @ProjectName bc-admin-web  
* @Description:   
* @Author ttsf-pzg
* @Date 2018年7月24日上午10:09:38  
* @Version V1.0
 */
@Component
public class UserServiceApiFallbackFactory extends FallbackFactoryBase  implements FallbackFactory<UserServiceApiRpc>  {

	@Override
	public UserServiceApiRpc create(Throwable arg0) {
		return new UserServiceApiRpc() {

			@Override
			public Result selectUserInfoById(int id) {
				return getTimeOut();
			}

			@Override
			public Result addUserInfo(UserInfo userInfo) {
				return getTimeOut();
			}

			@Override
			public Result deleteUserInfoByUserId(int id) {
				return getTimeOut();
			}

			@Override
			public Result updateUserInfoByUserId(UserInfoVo vo) {
				return getTimeOut();
			}

			@Override
			public Result userUpdatePwd(UserInfo userInfo) {
				return getTimeOut();
			}

			@Override
			public Result checkUserName(String userName) {
				return getTimeOut();
			}

			@Override
			public Result changeUserInfoStatus(int userId, int changeType) {
				return getTimeOut();
			}

			@Override
			public Result userLogin(UserInfoVo userInfoVo) {
				return getTimeOut();
			}

			@Override
			public Result updateUserRoleIdsByUserInfoId(UserInfoVo vo) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Result selectUserInfoByRoleIds(UserInfo userInfo) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Result selectUserInfoListByPage(int num, int size) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Result selectUserInfoList() {
				// TODO Auto-generated method stub
				return null;
			}
		
		};
	}

}
