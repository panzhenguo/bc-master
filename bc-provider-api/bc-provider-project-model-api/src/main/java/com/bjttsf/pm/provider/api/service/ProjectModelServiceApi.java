package com.bjttsf.pm.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bjttsf.core.Result;
import com.bjttsf.pm.model.domain.ProjectModel;

/**
 * 项目模型方法接口
 * 
 * @Title: ProjectModelServiceApi.java
 * @Package com.bjttsf.pm.provider.api.service
 * @ProjectName bc-provider-project-model-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月26日下午4:30:21
 * @Version V1.0
 */
@RequestMapping("/projectModel")
public interface ProjectModelServiceApi {

	/**
	 * 根据ID 查询项目模型
	 * 
	 * @Title: selectProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:30:45
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectProjectModelById/{id}")
	public Result selectProjectModelById(@PathVariable int id);

	/**
	 * 添加一个项目模型
	 * 
	 * @Title: addProjectModel
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:31:04
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 */
	@RequestMapping("/addProjectModel")
	public Result addProjectModel(ProjectModel add);

	/**
	 * 根据ID 删除项目模型
	 * 
	 * @Title: deleteProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:31:18
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteProjectModelById/{id}")
	public Result deleteProjectModelById(@PathVariable int id);

	/**
	 * 修改项目模型
	 * 
	 * @Title: updateProjectModelById
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:31:34
	 * @Author ttsf-lfs
	 * @param del
	 * @return
	 */
	@RequestMapping("/updateProjectModelById")
	public Result updateProjectModelById(ProjectModel del);

}
