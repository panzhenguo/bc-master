package com.bjttsf.api.company;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.company.model.domain.CompanyDepartemt;
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

@Api("部门接口")
@RestController
@RequestMapping("/companyDepartment")
public class CompanyDepartmentApi {
	@ApiOperation("根据ID 查询部门信息")
	@ApiImplicitParam(name = "id", value = "部门ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectCompanyDepartemtById/{id}", method = RequestMethod.GET)
	public Result selectCompanyDepartemtById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个部门信息 ")
	@ApiImplicitParam(name = "companyDepartemt", value = "部门实体参数", required = true, dataType = "companyDepartemt", paramType = "body")
	@RequestMapping(value = "/addCompanyDepartemt", method = RequestMethod.POST)
	public Result addCompanyDepartemt(CompanyDepartemt companyDepartemt) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除部门")
	@ApiImplicitParam(name = "id", value = "部门ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteCompanyDepartemtById/{id}", method = RequestMethod.POST)
	public Result deleteCompanyDepartemtById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改部门信息 ")
	@ApiImplicitParam(name = "companyDepartemt", value = "部门实体参数", required = true, dataType = "companyDepartemt", paramType = "body")
	@RequestMapping(value = "/updateCompanyDepartemt", method = RequestMethod.POST)
	public Result updateCompanyDepartemt(CompanyDepartemt companyDepartemt) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
