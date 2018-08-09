package ${basePackage}.provider.api.service;
import ${basePackage}.model.domain.${modelNameUpperCamel};
import ${basePackage}.support.Service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjttsf.core.Result;
import com.bjttsf.model.domain.${modelNameUpperCamel};


/**
 * Created by ${author} on ${date}.
 */
public interface ${modelNameUpperCamel}ServiceApi {

	
	@RequestMapping("/selectUserById/{id}")
	public Result select${modelNameUpperCamel}ById(@PathVariable int id);
	
	@RequestMapping("/addUserInfo")
	public Result add${modelNameUpperCamel}(${modelNameUpperCamel} add);
	
	@RequestMapping("/deleteUserInfoByUserId/{id}")
	public Result delete${modelNameUpperCamel}ByUserId(@PathVariable int id);
	
	@RequestMapping("/updateUserInfoByUserId")
	public Result update${modelNameUpperCamel}ByUserId( ${modelNameUpperCamel} del);
	
}
