package com.bjttsf.ur.provider.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.ur.mapper.UserRoleMapper;
import com.bjttsf.ur.model.domain.UserRole;
import com.bjttsf.ur.provider.api.service.UserRoleServiceApi;

import tk.mybatis.mapper.entity.Example;

@RestController
public class UserRoleServiceApiImpl implements UserRoleServiceApi {
	@Autowired
	UserRoleMapper userRoleMapping;

	/**
	 * 根据条件查询角色
	 * 
	 * @Title: selectUserRoleById
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:04:44
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.UserRoleServiceApi#selectUserRoleById(int)
	 */
	@Override
	public Result selectUserRoleById(@PathVariable int id) {
		UserRole userRole = userRoleMapping.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(userRole);
	}

	/**
	 * 添加一个角色
	 * 
	 * @Title: addUserRole
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:05:21
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 * @see com.bjttsf.provider.api.service.UserRoleServiceApi#addUserRole(com.bjttsf.model.domain.UserRole)
	 */
	@Override
	public Result addUserRole(UserRole userRole) {
		if (userRole != null) {
			Example ex = new Example(UserRole.class);
			ex.createCriteria().andEqualTo("roleName", userRole.getRoleName());
			int selectCountByExample = userRoleMapping.selectCountByExample(ex);
			if (selectCountByExample == 0) {
				userRole.setCreateDate(new Date());
				userRole.setCreateUserId(1);
				userRole.setStatus(0);
				userRoleMapping.insert(userRole);
				return ResultGenerator.getSuccessResult();
			} else {
				return ResultGenerator.getFailResult("角色已存在");
			}
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除角色
	 * 
	 * @Title: deleteUserRole
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:05:41
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.UserRoleServiceApi#deleteUserRole(int)
	 */
	@Override
	public Result deleteUserRoleByid(@PathVariable int id) {
		if (id > 0) {
			UserRole ur = new UserRole();
			ur.setId(id);
			ur.setStatus(-1);
			userRoleMapping.updateByPrimaryKeySelective(ur);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改一个角色
	 * 
	 * @Title: updateUserRole
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:06:10
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 * @see com.bjttsf.provider.api.service.UserRoleServiceApi#updateUserRole(com.bjttsf.model.domain.UserRole)
	 */
	@Override
	public Result updateUserRole(UserRole userRole) {
		if (userRole != null && userRole.getId() != null && userRole.getId() > 0) {
			userRoleMapping.updateByPrimaryKeySelective(userRole);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据实体属性查询角色
	 * 
	 * @Title: selectUserRoleByName
	 * @Description:
	 * @CreateTime 2018年7月26日下午1:54:24
	 * @Author ttsf-lfs
	 * @param userRole
	 * @return
	 * @see com.bjttsf.ur.provider.api.service.UserRoleServiceApi#selectUserRoleByName(com.bjttsf.ur.model.domain.UserRole)
	 */
	@Override
	public Result selectUserRoleByName(UserRole userRole) {
		List<UserRole> list = userRoleMapping.select(userRole);
		return ResultGenerator.getSuccessResult(list);
	}

	/**
	 * 获取全部角色信息
	 * 
	 * @Title: selectUserRoleAll
	 * @Description:
	 * @CreateTime 2018年8月8日上午10:28:24
	 * @Author ttsf-lfs
	 * @return
	 * @see com.bjttsf.ur.provider.api.service.UserRoleServiceApi#selectUserRoleAll()
	 */
	@Override
	public Result selectUserRoleAll() {
		List<UserRole> list = userRoleMapping.selectAll();
		return ResultGenerator.getSuccessResult(list);
	}

}
