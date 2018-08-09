package com.bjttsf.company.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.bjttsf.company.model.domain.CompanyDepartemt;
import com.bjttsf.mybatis.BcMapper;

@Mapper
public interface CompanyDepartemtMapper extends BcMapper<CompanyDepartemt> {
    @Update("UPDATE cw_company_department SET `status`=-1 WHERE company_id=#{id}")
    public void updateCompanyDepartemtByCompanyId(int id);
}