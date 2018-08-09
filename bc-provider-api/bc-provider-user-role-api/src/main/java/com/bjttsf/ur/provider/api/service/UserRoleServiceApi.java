package com.bjttsf.ur.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.core.Result;
import com.bjttsf.ur.model.domain.UserRole;

/**
 * 用户角色方法接口
 * 
 * @Title: UserRoleServiceApi.java
 * @Package com.bjttsf.ur.provider.api.service
 * @ProjectName bc-provider-user-role-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月26日下午1:21:19
 * @Version V1.0
 */
@RequestMapping("/userRole")
public interface UserRoleServiceApi {
	/**
	 * 根据ID 查询角色
	 * 
	 * @Title: selectUserRoleById
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:21:58
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectUserRoleById/{id}")
	public Result selectUserRoleById(@PathVariable int id);

	/**
	 * 根据实体属性查询角色
	 * 
	 * @Title: selectUserRoleByName
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:52:21
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 */
	@RequestMapping("/selectUserRoleByName")
	public Result selectUserRoleByName(UserRole userRole);

	/**
	 * 添加一个角色
	 * 
	 * @Title: addUserRole
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:22:19
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 */
	@RequestMapping("/addUserRole")
	public Result addUserRole(UserRole userRole);

	/**
	 * 根据ID 删除角色
	 * 
	 * @Title: deleteUserRoleByid
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:22:30
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUserRoleByid/{id}")
	public Result deleteUserRoleByid(@PathVariable int id);

	/**
	 * 修改一个角色
	 * 
	 * @Title: updateUserRole
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:22:51
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 */
	@RequestMapping("/updateUserRole")
	public Result updateUserRole(UserRole userRole);
	/**
	 * 获取全部角色信息
	 * @Title: selectUserRoleAll  
	 * @Description: 
	 * @CreateTime 2018年8月8日上午10:26:18
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 */
	@RequestMapping("/selectUserRoleAll")
	public Result selectUserRoleAll();
}
