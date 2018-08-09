package com.bjttsf.api.pm;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.pm.model.domain.ProjectModel;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("项目模板接口")
@RestController
@RequestMapping("/projectMode")
public class ProjectModelApi {
	@ApiOperation("根据ID 查询项目模型")
	@ApiImplicitParam(name = "id", value = "项目模板ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectProjectModelById/{id}", method = RequestMethod.GET)
	public Result selectProjectModelById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("添加一个项目模型 ")
	@ApiImplicitParam(name = "add", value = "项目模板实体参数", required = true, dataType = "add", paramType = "body")
	@RequestMapping(value = "/addProjectModel", method = RequestMethod.POST)
    public Result addProjectModel(ProjectModel add) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID 删除项目模型")
	@ApiImplicitParam(name = "id", value = "项目模板ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteProjectModelById/{id}", method = RequestMethod.POST)
	public Result deleteProjectModelById(@PathVariable int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改项目模型 ")
	@ApiImplicitParam(name = "del", value = "项目模板实体参数", required = true, dataType = "del", paramType = "body")
	@RequestMapping(value = "/updateProjectModelById", method = RequestMethod.POST)
	public Result updateProjectModelById(ProjectModel del) {
		return ResultGenerator.getSuccessResult("ok");
	}
}
