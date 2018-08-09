package com.bjttsf.api.ce;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.ce.model.domain.CompanyEmployee;
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


@Api(value="员工接口")
@RestController
@RequestMapping("/companyEmployee")
public class CompanyEmployeeApi {
	@ApiOperation("根据ID 查询员工信息")
	@ApiImplicitParam(name = "id", value = "员工ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectCompanyEmployeeById/{id}", method = RequestMethod.GET)
	public Result selectCompanyEmployeeById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个员工信息 ")
	@ApiImplicitParam(name = "add", value = "员工实体参数", required = true, dataType = "add", paramType = "body")
	@RequestMapping(value = "/addCompanyEmployee", method = RequestMethod.POST)
	public Result addCompanyEmployee(CompanyEmployee add) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除员工")
	@ApiImplicitParam(name = "id", value = "员工ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteCompanyEmployeeById/{id}", method = RequestMethod.POST)
	public Result deleteCompanyEmployeeByUserId(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改员工信息 ")
	@ApiImplicitParam(name = "del", value = "员工实体参数", required = true, dataType = "del", paramType = "body")
	@RequestMapping(value = "/updateCompanyEmployeeById", method = RequestMethod.POST)
	public Result updateCompanyEmployeeByUserId( CompanyEmployee del) {
		return ResultGenerator.getSuccessResult("ok");
	}
	@ApiOperation("根据部门查询员工信息 ")
	@ApiImplicitParam(name = "companyEmployee", value = "员工实体参数", required = true, dataType = "companyEmployee", paramType = "body")
	@RequestMapping(value = "/selectCompanyEmployeeByDepartemtId", method = RequestMethod.POST)
	public Result selectCompanyEmployeeByDepartemtId( CompanyEmployee companyEmployee) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
