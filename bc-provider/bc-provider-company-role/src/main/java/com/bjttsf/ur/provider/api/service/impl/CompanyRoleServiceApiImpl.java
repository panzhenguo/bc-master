package com.bjttsf.ur.provider.api.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.common.utils.StringUtils;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.cr.model.domain.CompanyRole;
import com.bjttsf.cr.provider.api.service.CompanyRoleServiceApi;
import com.bjttsf.ur.mapper.CompanyRoleMapper;

@RestController
public class CompanyRoleServiceApiImpl implements CompanyRoleServiceApi {
	@Autowired
	private CompanyRoleMapper cwCompanyRoleMapper;

	/**
	 * 根据条件查询企业角色
	 * 
	 * @Title: selectCompanyRoleById
	 * @Description:
	 * @CreateTime 2018年7月24日下午1:36:17
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyRoleServiceApi#selectCompanyRoleById(int)
	 */
	@Override
	public Result selectCompanyRoleById(@PathVariable int id) {
		CompanyRole cr = cwCompanyRoleMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(cr);
	}

	/**
	 * 添加一个企业角色
	 * 
	 * @Title: addCompanyRole
	 * @Description:
	 * @CreateTime 2018年7月24日下午1:37:10
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyRoleServiceApi#addCompanyRole(com.bjttsf.cr.model.domain.CompanyRole)
	 */
	@Override
	public Result addCompanyRole(CompanyRole add) {
		if (add != null && !StringUtils.isNull(add.getCompanyId() + "")) {
			add.setStatus(1);
			add.setCreateDate(new Date());
			add.setCreateUeType(1);
			cwCompanyRoleMapper.insert(add);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除角色
	 * 
	 * @Title: deleteCompanyRoleById
	 * @Description:
	 * @CreateTime 2018年7月24日下午1:42:42
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyRoleServiceApi#deleteCompanyRoleById(int)
	 */
	@Override
	public Result deleteCompanyRoleById(@PathVariable int id) {
		if (id > 0) {
			CompanyRole cr = new CompanyRole();
			cr.setId(id);
			cr.setStatus(-1);
			cwCompanyRoleMapper.updateByPrimaryKeySelective(cr);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改一个企业角色
	 * 
	 * @Title: updateCompanyRoleById
	 * @Description:
	 * @CreateTime 2018年7月24日下午1:46:19
	 * @Author ttsf-lfs
	 * @param del
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyRoleServiceApi#updateCompanyRoleById(com.bjttsf.cr.model.domain.CompanyRole)
	 */
	@Override
	public Result updateCompanyRoleById(CompanyRole del) {
		if (del != null && del.getId() != null && del.getId() > 0) {
			cwCompanyRoleMapper.updateByPrimaryKey(del);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

}
