package com.bjttsf.ce.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.bjttsf.ce.model.domain.CompanyEmployee;
import com.bjttsf.mybatis.BcMapper;

@Mapper
public interface CompanyEmployeeMapper extends BcMapper<CompanyEmployee> {
    
	@Select("select user_name userName from cw_company_employee where company_department_id ="
			+ " #{companyEmployee.companyDepartmentId}")
	List<CompanyEmployee> selectCompanyEmployeeByDepartemtId(@Param("companyEmployee")CompanyEmployee companyEmployee);
}