package com.bjttsf.api.company;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.company.model.domain.Company;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("企业接口")
@RestController
@RequestMapping("/company")
public class CompanyApi {
	@ApiOperation("根据ID 查询企业信息")
	@ApiImplicitParam(name = "id", value = "企业ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectCompanyById/{id}", method = RequestMethod.GET)
	public Result selectCompanyById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个企业信息 ")
	@ApiImplicitParam(name = "company", value = "企业实体参数", required = true, dataType = "company", paramType = "body")
	@RequestMapping(value = "/addCompany", method = RequestMethod.POST)
	public Result addCompany(Company company) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除企业")
	@ApiImplicitParam(name = "id", value = "企业ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteCompanyById/{id}", method = RequestMethod.POST)
	public Result deleteCompanyById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改企业信息 ")
	@ApiImplicitParam(name = "company", value = "企业实体参数", required = true, dataType = "company", paramType = "body")
	@RequestMapping(value = "/updateCompany", method = RequestMethod.POST)
	public Result updateCompany(Company company) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据企业名称及状态查询企业信息 ")
	@ApiImplicitParam(name = "company", value = "企业实体参数", required = true, dataType = "company", paramType = "body")
	@RequestMapping(value = "/selectCompanyByNameAndStatus", method = RequestMethod.POST)
	public Result selectCompanyByNameAndStatus(Company company) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
