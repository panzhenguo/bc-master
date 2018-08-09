package com.bjttsf.ce.provider.api.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.ce.mapper.CompanyEmployeeMapper;
import com.bjttsf.ce.model.domain.CompanyEmployee;
import com.bjttsf.ce.provider.api.service.CompanyEmployeeServiceApi;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;

@RestController
public class CompanyEmployeeServiceApiImpl implements CompanyEmployeeServiceApi {
	@Autowired
	private CompanyEmployeeMapper cwCompanyEmployeeMapper;

	/**
	 * 根据条件查询员工信息
	 * 
	 * @Title: selectCompanyEmployeeById
	 * @Description:
	 * @CreateTime 2018年7月23日下午3:15:25
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyEmployeeServiceApi#selectCompanyEmployeeById(int)
	 */
	@Override
	public Result selectCompanyEmployeeById(@PathVariable int id) {

		CompanyEmployee cep = cwCompanyEmployeeMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(cep);
	}

	/**
	 * 添加一个员工信息
	 * 
	 * @Title: addCompanyEmployee
	 * @Description:
	 * @CreateTime 2018年7月23日下午3:17:19
	 * @Author ttsf-lfs
	 * @param add
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyEmployeeServiceApi#addCompanyEmployee(com.bjttsf.model.domain.CompanyEmployee)
	 */
	@Override
	public Result addCompanyEmployee(CompanyEmployee add) {
		if (add != null && add.getPhone().length() == 1 && add.getIdCard().length() <= 18) {
			add.setPwdSalt(UUID.randomUUID().toString().replaceAll("", ""));
			add.setStatus(1);
			cwCompanyEmployeeMapper.insert(add);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除员工信息
	 * 
	 * @Title: deleteCompanyEmployeeByUserId
	 * @Description:
	 * @CreateTime 2018年7月23日下午3:23:03
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyEmployeeServiceApi#deleteCompanyEmployeeByUserId(int)
	 */
	@Override
	public Result deleteCompanyEmployeeByUserId(@PathVariable int id) {
		if (id > 0) {
			CompanyEmployee ce = new CompanyEmployee();
			ce.setId(id);
			ce.setStatus(-1);
			cwCompanyEmployeeMapper.updateByPrimaryKeySelective(ce);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改员工信息
	 * 
	 * @Title: updateCompanyEmployeeByUserId
	 * @Description:
	 * @CreateTime 2018年7月23日下午3:21:29
	 * @Author ttsf-lfs
	 * @param del
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyEmployeeServiceApi#updateCompanyEmployeeByUserId(com.bjttsf.model.domain.CompanyEmployee)
	 */
	@Override
	public Result updateCompanyEmployeeByUserId(CompanyEmployee updata) {
		if (updata != null && updata.getId() != null && updata.getId() > 0) {
			cwCompanyEmployeeMapper.updateByPrimaryKey(updata);
			return ResultGenerator.getSuccessResult();
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据部门查询员工信息
	 * 
	 * @Title: selectCompanyEmployeeByDepartemtId
	 * @Description:
	 * @CreateTime 2018年7月30日上午11:28:25
	 * @Author ttsf-lfs
	 * @param companyEmployee
	 * @return
	 * @see com.bjttsf.ce.provider.api.service.CompanyEmployeeServiceApi#selectCompanyEmployeeByDepartemtId(com.bjttsf.ce.model.domain.CompanyEmployee)
	 */
	@Override
	public Result selectCompanyEmployeeByDepartemtId(CompanyEmployee companyEmployee) {
		if (companyEmployee.getCompanyDepartmentId() == null) {
			return ResultGenerator.getFailResultByServiceApiParm();
		}
		List<CompanyEmployee> list = cwCompanyEmployeeMapper.selectCompanyEmployeeByDepartemtId(companyEmployee);
		return ResultGenerator.getSuccessResult(list);
	}
}
