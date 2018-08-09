package com.bjttsf.user.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.mybatis.BcMapper;
import com.bjttsf.user.model.domain.UserLoginLog;

@Mapper
public interface UserLoginLogMapper extends BcMapper<UserLoginLog> {
}