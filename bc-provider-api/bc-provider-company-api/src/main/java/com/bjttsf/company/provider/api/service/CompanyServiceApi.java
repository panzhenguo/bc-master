package com.bjttsf.company.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bjttsf.company.model.domain.Company;
import com.bjttsf.core.Result;

/**
 * 企业方法接口
 * 
 * @Title: CompanyServiceApi.java
 * @Package com.bjttsf.company.provider.api.service
 * @ProjectName bc-provider-company-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月25日上午9:12:02
 * @Version V1.0
 */

@RequestMapping("/company")
public interface CompanyServiceApi {
	/**
	 * 根据ID 查询一个企业信息
	 * 
	 * @Title: selectCompanyById
	 * @Description:
	 * @CreateTime 2018年7月25日上午9:12:41
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectCompanyById/{id}")
	public Result selectCompanyById(@PathVariable int id);
	/**
	 * 根据企业名称及状态查询企业信息
	 * @Title: selectCompanyByNameAndStatus  
	 * @Description: 
	 * @CreateTime 2018年7月26日上午11:09:05
	 * @Author ttsf-lfs
	 * @param name
	 * @return
	 */
	@RequestMapping("/selectCompanyByNameAndStatus")
	public Result selectCompanyByNameAndStatus(Company company);
	/**
	 * 添加一个企业信息
	 * 
	 * @Title: addCompany
	 * @Description:
	 * @CreateTime 2018年7月25日上午9:13:09
	 * @Author ttsf-lfs
	 * @param company
	 * @return
	 */
	@RequestMapping("/addCompany")
	public Result addCompany(Company company);

	/**
	 * 根据ID 删除一个企业信息
	 * 
	 * @Title: deleteCompanyById
	 * @Description:
	 * @CreateTime 2018年7月25日上午9:13:41
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteCompanyById/{id}")
	public Result deleteCompanyById(@PathVariable int id);

	/**
	 * 根据ID 修改一个企业对象
	 * 
	 * @Title: updateCompany
	 * @Description:
	 * @CreateTime 2018年7月25日上午9:14:09
	 * @Author ttsf-lfs
	 * @param company
	 * @return
	 */
	@RequestMapping("/updateCompany")
	public Result updateCompany(Company company);

}
