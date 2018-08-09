package com.bjttsf.ur.provider.api.service.impl;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.cr.model.domain.CompanyResources;
import com.bjttsf.cr.provider.api.service.CompanyResourcesServiceApi;
import com.bjttsf.ur.mapper.CompanyResourcesMapper;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class CompanyResourcesServiceApiImpl implements CompanyResourcesServiceApi {
	@Autowired
	private CompanyResourcesMapper cwCompanyResourcesMapper;

	/**
	 * 根据条件查询企业资源
	 * 
	 * @Title: selectCompanyResourcesById
	 * @Description:
	 * @CreateTime 2018年7月24日下午2:08:36
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyResourcesServiceApi#selectCompanyResourcesById(int)
	 */
	@Override
	public Result selectCompanyResourcesById(@PathVariable int id) {
		CompanyResources crc = cwCompanyResourcesMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(crc);
	}

	/**
	 * 添加一个企业资源
	 * 
	 * @Title: addCompanyResources
	 * @Description:
	 * @CreateTime 2018年7月24日下午2:10:30
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyResourcesServiceApi#addCompanyResources(com.bjttsf.cr.model.domain.CompanyResources)
	 */
	@Override
	public Result addCompanyResources(CompanyResources add) {
		if (add != null) {
			add.setCreateDate(new Date());
			add.setStatus(1);
			add.setCreateUeType(1);
			cwCompanyResourcesMapper.insert(add);
			return ResultGenerator.getSuccessResult();
		}

		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除一个企业资源
	 * 
	 * @Title: deleteCompanyResourcesByUserId
	 * @Description:
	 * @CreateTime 2018年7月24日下午2:12:13
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyResourcesServiceApi#deleteCompanyResourcesByUserId(int)
	 */
	@Override
	public Result deleteCompanyResourcesByUserId(@PathVariable int id) {
		if (id > 0) {
			CompanyResources cr = new CompanyResources();
			cr.setId(id);
			cr.setStatus(-1);
			cwCompanyResourcesMapper.updateByPrimaryKeySelective(cr);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改一个企业资源
	 * 
	 * @Title: updateCompanyResourcesByUserId
	 * @Description:
	 * @CreateTime 2018年7月24日下午2:14:20
	 * @Author ttsf-lfs
	 * @param del
	 * @return
	 * @see com.bjttsf.cr.provider.api.service.CompanyResourcesServiceApi#updateCompanyResourcesByUserId(com.bjttsf.cr.model.domain.CompanyResources)
	 */
	@Override
	public Result updateCompanyResourcesByUserId(CompanyResources del) {

		if (del != null && del.getId() != null && del.getId() > 0) {
			cwCompanyResourcesMapper.updateByPrimaryKey(del);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}
}
