package com.bjttsf.company.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.company.model.domain.CompanyDepartemt;
import com.bjttsf.core.Result;

/**
 * 企业部门方法接口
 * 
 * @Title: CompanyDepartemtServiceApi.java
 * @Package com.bjttsf.company.provider.api.service
 * @ProjectName bc-provider-company-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月26日上午9:47:00
 * @Version V1.0
 */
@RequestMapping("/companyDepartemt")
public interface CompanyDepartemtServiceApi {
	/**
	 * 根据ID 查询部门
	 * 
	 * @Title: selectCompanyDepartemtById
	 * @Description:
	 * @CreateTime 2018年7月26日上午9:47:15
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectCompanyDepartemtById/{id}")
	public Result selectCompanyDepartemtById(@PathVariable int id);

	/**
	 * 添加一个部门
	 * 
	 * @Title: addCompanyDepartemt
	 * @Description:
	 * @CreateTime 2018年7月26日上午9:47:33
	 * @Author ttsf-lfs
	 * @param companyDepartemt
	 * @return
	 */
	@RequestMapping("/addCompanyDepartemt")
	public Result addCompanyDepartemt(CompanyDepartemt companyDepartemt);

	/**
	 * 根据ID 删除一个部门
	 * 
	 * @Title: deleteCompanyDepartemtById
	 * @Description:
	 * @CreateTime 2018年7月26日上午9:47:46
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteCompanyDepartemtById/{id}")
	public Result deleteCompanyDepartemtById(@PathVariable int id);

	/**
	 * 修改部门信息
	 * 
	 * @Title: updateCompanyDepartemt
	 * @Description:
	 * @CreateTime 2018年7月26日上午9:48:04
	 * @Author ttsf-lfs
	 * @param companyDepartemt
	 * @return
	 */
	@RequestMapping("/updateCompanyDepartemt")
	public Result updateCompanyDepartemt(CompanyDepartemt companyDepartemt);
}
