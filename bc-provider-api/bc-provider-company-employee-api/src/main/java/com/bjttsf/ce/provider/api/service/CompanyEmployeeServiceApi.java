package com.bjttsf.ce.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.ce.model.domain.CompanyEmployee;
import com.bjttsf.core.Result;



@RequestMapping("/companyEmployee")
public interface CompanyEmployeeServiceApi {

	
	@RequestMapping("/selectCompanyEmployeeById/{id}")
	public Result selectCompanyEmployeeById(@PathVariable int id);
	
	@RequestMapping("/addCompanyEmployee")
	public Result addCompanyEmployee(CompanyEmployee add);
	
	@RequestMapping("/deleteCompanyEmployeeById/{id}")
	public Result deleteCompanyEmployeeByUserId(@PathVariable int id);
	
	@RequestMapping("/updateCompanyEmployeeById")
	public Result updateCompanyEmployeeByUserId( CompanyEmployee del);
	
	@RequestMapping("/selectCompanyEmployeeByDepartemtId")
	public Result selectCompanyEmployeeByDepartemtId( CompanyEmployee companyEmployee);
	
}
