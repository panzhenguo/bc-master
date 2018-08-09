package com.bjttsf.api.ur;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.ur.model.domain.UserRole;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("用户角色接口")
@RestController
@RequestMapping("/userRole")
public class UserRoleApi {

	@ApiOperation("根据ID 查询角色")
	@ApiImplicitParam(name = "id", value = "角色ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectUserRoleById/{id}", method = RequestMethod.GET)
	public Result selectUserRoleById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据实体属性查询角色 ")
	@ApiImplicitParam(name = "userRole", value = "角色实体参数", required = true, dataType = "userRole", paramType = "body")
	@RequestMapping(value = "/selectUserRoleByName", method = RequestMethod.POST)
	public Result selectUserRoleByName(UserRole userRole) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个角色 ")
	@ApiImplicitParam(name = "userRole", value = "角色实体参数", required = true, dataType = "userRole", paramType = "body")
	@RequestMapping(value = "/addUserRole", method = RequestMethod.POST)
	public Result addUserRole(UserRole userRole) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除角色")
	@ApiImplicitParam(name = "id", value = "角色ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteUserRoleByid/{id}", method = RequestMethod.POST)
	public Result deleteUserRoleByid(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改一个角色 ")
	@ApiImplicitParam(name = "userRole", value = "角色实体参数", required = true, dataType = "userRole", paramType = "body")
	@RequestMapping(value = "/updateUserRole", method = RequestMethod.POST)
	public Result updateUserRole(UserRole userRole) {
		return ResultGenerator.getSuccessResult("ok");
	}
	@ApiOperation("获取全部角色信息")
	@RequestMapping(value = "/selectUserRoleAll", method = RequestMethod.POST)
	public Result selectUserRoleAll() {
		return ResultGenerator.getSuccessResult("ok");
	}
}
