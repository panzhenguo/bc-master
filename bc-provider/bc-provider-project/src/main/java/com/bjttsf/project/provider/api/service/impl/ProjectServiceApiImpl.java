package com.bjttsf.project.provider.api.service.impl;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.project.mapper.ProjectMapper;
import com.bjttsf.project.model.domain.Project;
import com.bjttsf.project.provider.api.service.ProjectServiceApi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ProjectServiceApiImpl implements ProjectServiceApi {
	@Autowired
	private ProjectMapper pmProjectMapper;

	/**
	 * 根据ID 查询项目
	 * 
	 * @Title: selectProjectById
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:14:57
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.project.provider.api.service.ProjectServiceApi#selectProjectById(int)
	 */
	@Override
	public Result selectProjectById(@PathVariable int id) {
		Project po = pmProjectMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(po);
	}

	/**
	 * 添加一个项目
	 * 
	 * @Title: addProject
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:15:26
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 * @see com.bjttsf.project.provider.api.service.ProjectServiceApi#addProject(com.bjttsf.project.model.domain.Project)
	 */
	@Override
	public Result addProject(Project add) {
		if (add != null) {
			add.setCreateDate(new Date());
			add.setStatus(1);
			add.setIndustry(1);
			return ResultGenerator.getSuccessResult(pmProjectMapper.insert(add));
		}
		return ResultGenerator.getFailResultByServiceApiParm();

	}

	/**
	 * 根据ID 删除项目
	 * 
	 * @Title: deleteProjectByProjectId
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:15:45
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.project.provider.api.service.ProjectServiceApi#deleteProjectByProjectId(int)
	 */
	@Override
	public Result deleteProjectByProjectId(@PathVariable int id) {
		if (id > 0) {
			Project po = new Project();
			po.setId(id);
			po.setStatus(-1);
			return ResultGenerator.getSuccessResult(pmProjectMapper.deleteByPrimaryKey(id));
		} else {
			return ResultGenerator.getFailResultByServiceApiParm();
		}
	}

	/**
	 * 修改项目信息
	 * 
	 * @Title: updateProjectByProjectId
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:16:05
	 * @Author ttsf-lfs
	 * @param updata
	 * @return
	 * @see com.bjttsf.project.provider.api.service.ProjectServiceApi#updateProjectByProjectId(com.bjttsf.project.model.domain.Project)
	 */
	@Override
	public Result updateProjectByProjectId(Project updata) {
		if (updata != null && updata.getId() != null && updata.getId() > 0) {
			return ResultGenerator.getSuccessResult(pmProjectMapper.updateByPrimaryKeySelective(updata));
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

}
