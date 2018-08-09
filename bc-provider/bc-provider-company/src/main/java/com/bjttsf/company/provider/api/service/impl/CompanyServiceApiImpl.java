package com.bjttsf.company.provider.api.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.bjttsf.common.utils.PinYin4J;
import com.bjttsf.company.mapper.CompanyDepartemtMapper;
import com.bjttsf.company.mapper.CompanyMapper;
import com.bjttsf.company.model.domain.Company;
import com.bjttsf.company.provider.api.service.CompanyServiceApi;
import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import tk.mybatis.mapper.entity.Example;
@RestController
public class CompanyServiceApiImpl implements CompanyServiceApi {

	@Autowired
	private CompanyMapper CompanyMapping;
	@Autowired
	private CompanyDepartemtMapper CompanyDepartemtMapping;

	/**
	 * 根据条件查询企业信息
	 * 
	 * @Title: selectCompanyById
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:40:03
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyServiceApi#selectCompanyById(int)
	 */
	@Override
	public Result selectCompanyById(@PathVariable int id) {
		Company cp = CompanyMapping.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(cp);
	}

	/**
	 * 添加一个企业信息
	 * 
	 * @Title: addCompany
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:40:36
	 * @Author ttsf-lfs
	 * @param company
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyServiceApi#addCompany(com.bjttsf.model.domain.Company)
	 */
	@Override
	public Result addCompany(Company company) {
		if (company != null) {
			Example ex = new Example(Company.class);
			ex.createCriteria().andEqualTo("name", company.getName());
			int selectCountByExample = CompanyMapping.selectCountByExample(ex);
			// 判断企业是否存在
			if (selectCountByExample == 0) {
				PinYin4J pin = new PinYin4J(company.getName());
				company.setPinyinName(pin.getPinyinAll());
				company.setPinyinShortName(pin.getPinyinShort());
				company.setCreateDate(new Date());
				company.setCreateUserId(0);
				company.setStatus(1);
				return ResultGenerator.getSuccessResult(CompanyMapping.insert(company));
			} else {
				return ResultGenerator.getFailResult("企业名已存在");
			}
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据条件删除企业信息
	 * 
	 * @Title: deleteCompanyById
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:42:00
	 * @Author ttsf-lfs
	 * @param id
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyServiceApi#deleteCompanyById(int)
	 */
	@Override
	public Result deleteCompanyById(@PathVariable int id) {
		if (id > 0) {
			Company cp = new Company();
			cp.setId(id);
			cp.setStatus(-1);
			// 根据企业id 删除其下所有部门
			CompanyDepartemtMapping.updateCompanyDepartemtByCompanyId(id);
			return ResultGenerator.getSuccessResult(CompanyMapping.updateByPrimaryKeySelective(cp));
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 修改企业信息
	 * 
	 * @Title: updateCompany
	 * @Description:
	 * @CreateTime 2018年7月23日下午1:42:22
	 * @Author ttsf-lfs
	 * @param company
	 * @return
	 * @see com.bjttsf.provider.api.service.CompanyServiceApi#updateCompany(com.bjttsf.model.domain.Company)
	 */
	@Override
	public Result updateCompany(Company company) {
		if (company != null && company.getId() != null && company.getId() > 0) {
			Company selectByPrimaryKey = CompanyMapping.selectByPrimaryKey(company.getId());

			if (company.getName().equals(selectByPrimaryKey.getName())) {
				company.setUpdateDate(new Date());
				return ResultGenerator.getSuccessResult(CompanyMapping.updateByPrimaryKeySelective(company));
			} else {
				// 企业名称是否重复判断
				Example ex = new Example(Company.class);
				ex.createCriteria().andEqualTo("name", company.getName());
				int selectCountByExample = CompanyMapping.selectCountByExample(ex);
				if (selectCountByExample != 0) {
					return ResultGenerator.getFailResult("企业名称已存在");
				} else {
					PinYin4J pin = new PinYin4J(company.getName());
					company.setPinyinName(pin.getPinyinAll());
					company.setPinyinShortName(pin.getPinyinShort());
					company.setUpdateDate(new Date());
					return ResultGenerator.getSuccessResult(CompanyMapping.updateByPrimaryKeySelective(company));
				}
			}
		}
		return ResultGenerator.getFailResultByServiceApiParm();
	}

	/**
	 * 根据企业名称查询企业信息
	 * 
	 * @Title: selectCompanyByName
	 * @Description:
	 * @CreateTime 2018年7月26日上午11:09:44
	 * @Author ttsf-lfs
	 * @param name
	 * @return
	 * @see com.bjttsf.company.provider.api.service.CompanyServiceApi#selectCompanyByName(java.lang.String)
	 */
	@Override
	public Result selectCompanyByNameAndStatus(Company company) {
		List<Company> list = CompanyMapping.select(company);
		return ResultGenerator.getSuccessResult(list);
	}

}