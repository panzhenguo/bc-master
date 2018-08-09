package com.bjttsf.pm.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.mybatis.BcMapper;
import com.bjttsf.pm.model.domain.ProjectModel;


@Mapper
public interface ProjectModelMapper extends BcMapper<ProjectModel> {
}