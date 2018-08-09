package com.bjttsf.ur.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.mybatis.BcMapper;
import com.bjttsf.ur.model.domain.UserRole;

@Mapper
public interface UserRoleMapper extends BcMapper<UserRole> {
}