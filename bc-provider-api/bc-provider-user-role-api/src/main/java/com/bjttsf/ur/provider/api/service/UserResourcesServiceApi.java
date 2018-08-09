package com.bjttsf.ur.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.core.Result;
import com.bjttsf.ur.model.domain.UserResources;
import com.bjttsf.ur.model.domain.UserRole;

/**
 * 用户资源方法接口
 * 
 * @Title: UserResourcesServiceApi.java
 * @Package com.bjttsf.ur.provider.api.service
 * @ProjectName bc-provider-user-role-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月26日下午1:23:09
 * @Version V1.0
 */
@RequestMapping("/userResources")
public interface UserResourcesServiceApi {
	/**
	 * 根据ID 查询资源信息
	 * 
	 * @Title: selectUserResourcesById
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:23:24
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectUserResourcesById/{id}")
	public Result selectUserResourcesById(@PathVariable int id);

	/**
	 * 添加一个资源
	 * 
	 * @Title: addUserResources
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:23:46
	 * @Author ttsf-lfs
	 * @param userResources
	 * @return
	 */
	@RequestMapping("/addUserResources")
	public Result addUserResources(UserResources userResources);

	/**
	 * 根据ID 删除资源
	 * 
	 * @Title: deleteUserResourcesById
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:23:55
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteUserResourcesById/{id}")
	public Result deleteUserResourcesById(@PathVariable int id);

	/**
	 * 修改一个资源
	 * 
	 * @Title: updateUserResources
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:24:11
	 * @Author ttsf-lfs
	 * @param userResources
	 * @return
	 */
	@RequestMapping("/updateUserResources")
	public Result updateUserResources(UserResources userResources);

	/**
	 * 根据角色查询资源
	 * 
	 * @Title: selectUserResourcesByRoleId
	 * @Description:
	 * @CreateTime 2018年7月27日下午2:44:25
	 * @Author ttsf-lfs
	 * @param ids
	 * @return
	 */
	@RequestMapping("/selectUserResourcesByRoleId")
	public Result selectUserResourcesByRoleId(UserRole userRole);

}
