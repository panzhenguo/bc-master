package com.bjttsf.ur.provider.api.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.ur.mapper.UserResourcesMapper;
import com.bjttsf.ur.mapper.UserRoleMapper;
import com.bjttsf.ur.model.domain.UserResources;
import com.bjttsf.ur.model.domain.UserRole;
import com.bjttsf.ur.provider.api.service.UserResourcesServiceApi;

import tk.mybatis.mapper.entity.Example;

@RestController
public class UserResourcesServiceApiImpl implements UserResourcesServiceApi {
	@Autowired
	UserResourcesMapper userResourcesMapping;
    @Autowired
    UserRoleMapper userRoleMapping;
	/**
	 * 根据条件查询资源
	 * 
	 * @Title: selectUserResourcesById
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:50:56
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.UserResourcesServiceApi#selectUserResourcesById(int)
	 */
	@Override
	public Result selectUserResourcesById(@PathVariable int id) {
		UserResources userResources = userResourcesMapping.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(userResources);
	}

	/**
	 * 添加一个资源
	 * 
	 * @Title: addUserResources
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:51:16
	 * @Author ttsf-lfs
	 * @param userResources
	 * @return
	 * @see com.bjttsf.provider.api.service.UserResourcesServiceApi#addUserResources(com.bjttsf.model.domain.UserResources)
	 */
	@Override
	public Result addUserResources(UserResources userResources) {
		if (userResources != null) {
			Example ex = new Example(UserResources.class);
			ex.createCriteria().andEqualTo("resourcesName", userResources.getResourcesName());
			int selectCountByExample = userResourcesMapping.selectCountByExample(ex);
			if (selectCountByExample == 0) {
				userResources.setCreateDate(new Date());
				userResources.setStatus(1);
				userResources.setCreateUserId(0);
				userResources.setResourcesType(1);
				userResourcesMapping.insert(userResources);
				return ResultGenerator.getSuccessResult();
			} else {
				return ResultGenerator.getFailResult("资源已存在");
			}
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除资源
	 * 
	 * @Title: deleteUserResourcesById
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:51:40
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.UserResourcesServiceApi#deleteUserResourcesById(int)
	 */
	@Override
	public Result deleteUserResourcesById(@PathVariable int id) {
		if (id > 0) {
			UserResources ur = new UserResources();
			ur.setId(id);
			ur.setStatus(-1);
			userResourcesMapping.updateByPrimaryKeySelective(ur);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改一个资源
	 * 
	 * @Title: updateUserResources
	 * @Description:
	 * @CreateTime 2018年7月20日下午3:52:03
	 * @Author ttsf-lfs
	 * @param userResources
	 * @return
	 * @see com.bjttsf.provider.api.service.UserResourcesServiceApi#updateUserResources(com.bjttsf.model.domain.UserResources)
	 */
	@Override
	public Result updateUserResources(UserResources userResources) {
		if (userResources != null && userResources.getId() != null && userResources.getId() > 0) {
			userResourcesMapping.updateByPrimaryKey(userResources);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据角色查询资源
	 * 
	 * @Title: selectUserResourcesByRoleId
	 * @Description:
	 * @CreateTime 2018年7月27日下午2:44:41
	 * @Author ttsf-lfs
	 * @param ids
	 * @return
	 * @see com.bjttsf.ur.provider.api.service.UserResourcesServiceApi#selectUserResourcesByRoleId(java.lang.String)
	 */
	@Override
	public Result selectUserResourcesByRoleId(UserRole userRole) {
		UserRole selectByPrimaryKey = userRoleMapping.selectByPrimaryKey(userRole.getId());
	    String ids = selectByPrimaryKey.getResourcesIds();
		String rid = ids.replaceAll("[-,]", "");
		int rrid = Integer.parseInt(rid);
		UserResources ur = userResourcesMapping.selectByPrimaryKey(rrid);
		return ResultGenerator.getSuccessResult(ur);
	}

}
