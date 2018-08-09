package com.bjttsf.ur.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.mybatis.BcMapper;
import com.bjttsf.ur.model.domain.UserResources;

@Mapper
public interface UserResourcesMapper extends BcMapper<UserResources> {
}