package com.bjttsf.api.ur;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.ur.model.domain.UserResources;
import com.bjttsf.ur.model.domain.UserRole;

import io.swagger.annotations.Api;
//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

@Api("用户资源接口")
@RestController
@RequestMapping("/userResources")
public class UserResourcesApi {
	@ApiOperation("根据ID 查询资源")
	@ApiImplicitParam(name = "id", value = "资源ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectUserResourcesById/{id}", method = RequestMethod.GET)
	public Result selectUserResourcesById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个资源 ")
	@ApiImplicitParam(name = "userResources", value = "资源实体参数", required = true, dataType = "userResources", paramType = "body")
	@RequestMapping(value = "/addUserResources", method = RequestMethod.POST)
	public Result addUserResources(UserResources userResources) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除资源")
	@ApiImplicitParam(name = "id", value = "资源ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteUserResourcesById/{id}", method = RequestMethod.POST)
	public Result deleteUserResourcesById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改一个资源 ")
	@ApiImplicitParam(name = "userResources", value = "资源实体参数", required = true, dataType = "userResources", paramType = "body")
	@RequestMapping(value = "/updateUserResources", method = RequestMethod.POST)
	public Result updateUserResources(UserResources userResources) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据角色查询资源 ")
	@ApiImplicitParam(name = "userResources", value = "资源实体参数", required = true, dataType = "userResources", paramType = "body")
	@RequestMapping(value = "/selectUserResourcesByRoleId", method = RequestMethod.POST)
	public Result selectUserResourcesByRoleId(UserRole userRole) {
		return ResultGenerator.getSuccessResult("ok");
	}

}
