package com.bjttsf.api.cr;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.cr.model.domain.CompanyRole;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("企业角色接口")
@RestController
@RequestMapping("/companyRole")
public class CompanyRoleApi {
	@ApiOperation("根据ID 查询企业角色")
	@ApiImplicitParam(name = "id", value = "企业角色ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectCompanyRoleById/{id}", method = RequestMethod.GET)
	public Result selectCompanyRoleById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个企业角色 ")
	@ApiImplicitParam(name = "add", value = "企业角色实体参数", required = true, dataType = "add", paramType = "body")
	@RequestMapping(value = "/addCompanyRole", method = RequestMethod.POST)
	public Result addCompanyRole(CompanyRole add) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除企业角色")
	@ApiImplicitParam(name = "id", value = "企业角色ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteCompanyRoleById/{id}", method = RequestMethod.POST)
	public Result deleteCompanyRoleById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改企业角色 ")
	@ApiImplicitParam(name = "del", value = "企业角色实体参数", required = true, dataType = "del", paramType = "body")
	@RequestMapping(value = "/updateCompanyRoleById", method = RequestMethod.POST)
	public Result updateCompanyRoleById( CompanyRole del) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
