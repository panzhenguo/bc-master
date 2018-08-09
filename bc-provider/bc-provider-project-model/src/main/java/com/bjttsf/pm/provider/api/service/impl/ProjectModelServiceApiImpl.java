package com.bjttsf.pm.provider.api.service.impl;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.pm.mapper.ProjectModelMapper;
import com.bjttsf.pm.model.domain.ProjectModel;
import com.bjttsf.pm.provider.api.service.ProjectModelServiceApi;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ProjectModelServiceApiImpl implements ProjectModelServiceApi {
	@Autowired
	private ProjectModelMapper pmProjectModelMapper;

	/**
	 * 根据ID 查询项目模板
	 * 
	 * @Title: selectProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:12:11
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.pm.provider.api.service.ProjectModelServiceApi#selectProjectModelById(int)
	 */
	@Override
	public Result selectProjectModelById(@PathVariable int id) {
		ProjectModel pm = pmProjectModelMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(pm);
	}

	/**
	 * 添加项目模板
	 * 
	 * @Title: addProjectModel
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:13:34
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 * @see com.bjttsf.pm.provider.api.service.ProjectModelServiceApi#addProjectModel(com.bjttsf.pm.model.domain.ProjectModel)
	 */
	@Override
	public Result addProjectModel(ProjectModel add) {
		if (add != null) {
			add.setStatus(1);
			add.setCreateDate(new Date());
			return ResultGenerator.getSuccessResult(pmProjectModelMapper.insert(add));
		} else {
			return ResultGenerator.getFailResultByServiceApiParm();
		}
	}

	/**
	 * 根据ID 删除项目模板
	 * 
	 * @Title: deleteProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:13:54
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.pm.provider.api.service.ProjectModelServiceApi#deleteProjectModelById(int)
	 */
	@Override
	public Result deleteProjectModelById(@PathVariable int id) {
		if (id > 0) {
			ProjectModel po = new ProjectModel();
			po.setId(id);
			po.setStatus(-1);
			return ResultGenerator.getSuccessResult(pmProjectModelMapper.deleteByPrimaryKey(id));
		} else {
			return ResultGenerator.getFailResultByServiceApiParm();
		}
	}

	/**
	 * 修改项目模板
	 * 
	 * @Title: updateProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月27日下午1:14:23
	 * @Author ttsf-lfs
	 * @param updata
	 * @return
	 * @see com.bjttsf.pm.provider.api.service.ProjectModelServiceApi#updateProjectModelById(com.bjttsf.pm.model.domain.ProjectModel)
	 */
	@Override
	public Result updateProjectModelById(ProjectModel updata) {
		if (updata != null && updata.getId() != null && updata.getId() > 0) {
			pmProjectModelMapper.updateByPrimaryKeySelective(updata);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

}
