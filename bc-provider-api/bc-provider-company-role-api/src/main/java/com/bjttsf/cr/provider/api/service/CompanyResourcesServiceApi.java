package com.bjttsf.cr.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.core.Result;
import com.bjttsf.cr.model.domain.CompanyResources;


@RequestMapping("/companyResources")
public interface CompanyResourcesServiceApi {

	
	@RequestMapping("/selectCompanyResourcesById/{id}")
	public Result selectCompanyResourcesById(@PathVariable int id);
	
	@RequestMapping("/addCompanyResources")
	public Result addCompanyResources(CompanyResources add);
	
	@RequestMapping("/deleteCompanyResourcesById/{id}")
	public Result deleteCompanyResourcesByUserId(@PathVariable int id);
	
	@RequestMapping("/updateCompanyResourcesById")
	public Result updateCompanyResourcesByUserId( CompanyResources del);
	
}
