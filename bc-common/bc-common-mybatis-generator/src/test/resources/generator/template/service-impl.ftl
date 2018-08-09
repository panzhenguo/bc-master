package ${basePackage}.provider.api.service.provider.api.service.impl;


import ${basePackage}.mapper.${modelNameUpperCamel}Mapper;
import ${basePackage}.model.domain.${modelNameUpperCamel};
import ${basePackage}.provider.api.service.${modelNameUpperCamel}ServiceApi;
import com.bjttsf.core.Result;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by ${author} on ${date}.
 */
@Service
@Transactional
public class ${modelNameUpperCamel}ServiceApiImpl implements ${modelNameUpperCamel}ServiceApi {
    @Autowired
    private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;
    
    
    @Override
	public Result select${modelNameUpperCamel}ById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add${modelNameUpperCamel}(${modelNameUpperCamel} add) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete${modelNameUpperCamel}ByUserId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update${modelNameUpperCamel}ByUserId(${modelNameUpperCamel} del) {
		// TODO Auto-generated method stub
		return null;
	}

}
