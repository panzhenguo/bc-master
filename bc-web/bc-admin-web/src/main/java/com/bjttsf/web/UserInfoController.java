package com.bjttsf.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.rpc.UserServiceApiRpc;

@RestController
@RequestMapping("/adminUserInfo")
public class UserInfoController {
	
	@Autowired
	private UserServiceApiRpc rpc ;
	
	@RequestMapping("/getUserInfoById")
	public Result getUerInfoById() {
		
		Result r= rpc.selectUserInfoById(1);
		return r;
	} 
}
