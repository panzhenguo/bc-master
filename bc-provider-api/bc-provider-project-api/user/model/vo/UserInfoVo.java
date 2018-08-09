package com.bjttsf.user.model.vo;

import com.bjttsf.user.model.domain.UserInfo;

import lombok.Data;

@Data
public class UserInfoVo {

	private UserInfo userInfo;
	
	/**
	 * 修改用户信息时用于表示是否修改了密码
	 */
	private int updateUserInfoPwdIsChange=0;
}
