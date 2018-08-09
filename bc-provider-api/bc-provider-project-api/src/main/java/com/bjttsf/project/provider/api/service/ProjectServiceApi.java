package com.bjttsf.project.provider.api.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bjttsf.core.Result;
import com.bjttsf.project.model.domain.Project;

/**
 * 项目方法接口
 * 
 * @Title: ProjectServiceApi.java
 * @Package com.bjttsf.project.provider.api.service
 * @ProjectName bc-provider-project-api
 * @Description:
 * @Author ttsf-lfs
 * @Date 2018年7月26日下午4:25:15
 * @Version V1.0
 */
@RequestMapping("/project")
public interface ProjectServiceApi {

	/**
	 * 根据ID 查询项目
	 * 
	 * @Title: selectProjectById
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:25:49
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/selectProjectById/{id}")
	public Result selectProjectById(@PathVariable int id);

	/**
	 * 添加一个项目
	 * 
	 * @Title: addProject
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:26:11
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 */
	@RequestMapping("/addProject")
	public Result addProject(Project add);

	/**
	 * 根据ID 删除项目
	 * 
	 * @Title: deleteProjectByProjectId
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:26:24
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 */
	@RequestMapping("/deleteProjectByProjectId/{id}")
	public Result deleteProjectByProjectId(@PathVariable int id);

	/**
	 * 修改项目
	 * 
	 * @Title: updateProjectByProjectId
	 * @Description:
	 * @CreateTime 2018年7月26日下午4:26:51
	 * @Author ttsf-lfs
	 * @param del
	 * @return
	 */
	@RequestMapping("/updateProjectByProjectId")
	public Result updateProjectByProjectId(Project del);

}
