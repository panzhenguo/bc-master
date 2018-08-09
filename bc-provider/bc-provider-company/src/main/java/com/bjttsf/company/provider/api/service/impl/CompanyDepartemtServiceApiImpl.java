package com.bjttsf.company.provider.api.service.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.company.mapper.CompanyDepartemtMapper;
import com.bjttsf.company.model.domain.Company;
import com.bjttsf.company.model.domain.CompanyDepartemt;
import com.bjttsf.company.provider.api.service.CompanyDepartemtServiceApi;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import tk.mybatis.mapper.entity.Example;


@RestController
public class CompanyDepartemtServiceApiImpl implements CompanyDepartemtServiceApi {

	@Autowired
	CompanyDepartemtMapper CompanyDepartemtMapping;

	/**
	 * 根据条件查询部门信息
	 * 
	 * @Title: selectCompanyDepartemtById
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:38:23
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyDepartemtServiceApi#selectCompanyDepartemtById(int)
	 */
	@Override
	public Result selectCompanyDepartemtById(@PathVariable int id) {
		CompanyDepartemt cd = CompanyDepartemtMapping.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(cd);
	}

	/**
	 * 添加一个部门信息
	 * 
	 * @Title: addCompanyDepartemt
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:38:55
	 * @Author ttsf-lfs
	 * @param companyDepartemt
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyDepartemtServiceApi#addCompanyDepartemt(com.bjttsf.model.domain.CompanyDepartemt)
	 */
	@Override
	public Result addCompanyDepartemt(CompanyDepartemt companyDepartemt) {
		if (companyDepartemt != null) {
			Example ex = new Example(Company.class);
			ex.createCriteria().andEqualTo("name", companyDepartemt.getName());
			int selectCountByExample = CompanyDepartemtMapping.selectCountByExample(ex);
			//判断部门是否存在
			if (selectCountByExample == 0) {
				companyDepartemt.setCreateDate(new Date());
				companyDepartemt.setStatus(1);
				return ResultGenerator.getSuccessResult(CompanyDepartemtMapping.insert(companyDepartemt));
			} else {
				return ResultGenerator.getFailResult("部门已存在");
			}
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除部门信息
	 * 
	 * @Title: deleteCompanyDepartemtById
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:39:12
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyDepartemtServiceApi#deleteCompanyDepartemtById(int)
	 */
	@Override
	public Result deleteCompanyDepartemtById(@PathVariable int id) {
		if (id > 0) {
			CompanyDepartemt cd = new CompanyDepartemt();
			cd.setId(id);
			cd.setStatus(-1);
			return ResultGenerator.getSuccessResult(CompanyDepartemtMapping.updateByPrimaryKeySelective(cd));
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改一个部门信息
	 * 
	 * @Title: updateCompanyDepartemt
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:39:35
	 * @Author ttsf-lfs
	 * @param companyDepartemt
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyDepartemtServiceApi#updateCompanyDepartemt(com.bjttsf.model.domain.CompanyDepartemt)
	 */
	@Override
	public Result updateCompanyDepartemt(CompanyDepartemt companyDepartemt) {
		if (companyDepartemt != null && companyDepartemt.getId() != null && companyDepartemt.getId() > 0) {
            CompanyDepartemt selectByPrimaryKey = CompanyDepartemtMapping.selectByPrimaryKey(companyDepartemt.getId());
            if(companyDepartemt.getName().equals(selectByPrimaryKey.getName())) {
            	companyDepartemt.setUpdateDate(new Date());
            	return ResultGenerator.getSuccessResult(CompanyDepartemtMapping.updateByPrimaryKey(companyDepartemt));
            }else {
            	// 部门名称是否重复判断
				Example ex = new Example(Company.class);
				ex.createCriteria().andEqualTo("name", companyDepartemt.getName());
				int selectCountByExample = CompanyDepartemtMapping.selectCountByExample(ex);
				if(selectCountByExample!=0) {
					return ResultGenerator.getFailResult("部门名称已存在");
				}else {
					companyDepartemt.setUpdateDate(new Date());
	            	return ResultGenerator.getSuccessResult(CompanyDepartemtMapping.updateByPrimaryKey(companyDepartemt));
				}
            }
			
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

}
