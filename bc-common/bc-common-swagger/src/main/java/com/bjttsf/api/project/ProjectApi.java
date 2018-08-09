package com.bjttsf.api.project;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.project.model.domain.Project;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("项目接口")
@RestController
@RequestMapping("/project")
public class ProjectApi {
	@ApiOperation("根据ID 查询项目")
	@ApiImplicitParam(name = "id", value = "项目ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectProjectById/{id}", method = RequestMethod.GET)
	public Result selectProjectById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个项目 ")
	@ApiImplicitParam(name = "add", value = "项目实体参数", required = true, dataType = "add", paramType = "body")
	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public Result addProject(Project add) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除项目")
	@ApiImplicitParam(name = "id", value = "项目ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteProjectByProjectId/{id}", method = RequestMethod.POST)
	public Result deleteProjectByProjectId(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改项目 ")
	@ApiImplicitParam(name = "del", value = "项目实体参数", required = true, dataType = "del", paramType = "body")
	@RequestMapping(value = "/updateProjectByProjectId", method = RequestMethod.POST)
	public Result updateProjectByProjectId(Project del) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
