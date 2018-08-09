package com.bjttsf.company.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.bjttsf.company.model.domain.Company;
import com.bjttsf.mybatis.BcMapper;

@Mapper
public interface CompanyMapper extends BcMapper<Company> {


}