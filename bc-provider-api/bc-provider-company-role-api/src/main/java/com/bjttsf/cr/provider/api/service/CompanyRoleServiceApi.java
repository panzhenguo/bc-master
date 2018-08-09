package com.bjttsf.cr.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.core.Result;
import com.bjttsf.cr.model.domain.CompanyRole;


@RequestMapping("/companyRole")
public interface CompanyRoleServiceApi {

	
	@RequestMapping("/selectCompanyRoleById/{id}")
	public Result selectCompanyRoleById(@PathVariable int id);
	
	@RequestMapping("/addCompanyRole")
	public Result addCompanyRole(CompanyRole add);
	
	@RequestMapping("/deleteCompanyRoleById/{id}")
	public Result deleteCompanyRoleById(@PathVariable int id);
	
	@RequestMapping("/updateCompanyRoleById")
	public Result updateCompanyRoleById( CompanyRole del);
	
}
