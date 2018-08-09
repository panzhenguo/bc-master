package com.bjttsf.api.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bjttsf.core.Result;
import com.bjttsf.core.ResultGenerator;
import com.bjttsf.user.mapper.UserInfoMapper;
import com.bjttsf.user.model.domain.UserInfo;
import com.bjttsf.user.model.vo.UserInfoVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

//@Api 描述类/接口的主要用途
//@ApiOperation 描述方法用途
//@ApiImplicitParam 描述方法的参数
//@ApiImplicitParams 描述方法的参数(Multi-Params)
//@ApiIgnore 忽略某类/方法/参数的文档

@Api("用户接口")
@RestController
@RequestMapping("/userInfo")
public class UserInfoApi {
	@Autowired
	private UserInfoMapper userInfoMapper;

	@ApiOperation("根据ID查询一个用户实体")
	@ApiImplicitParam(name = "id", value = "用户ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/selectUserById/{id}", method = RequestMethod.GET)
	public Result selectUserInfoById(@PathVariable("id") int id) {
		UserInfo ru = userInfoMapper.selectByPrimaryKey(id);
		return ResultGenerator.getSuccessResult(ru);
	}

	@ApiOperation("添加一个用户")
	@ApiImplicitParam(name = "userInfo", value = "用户实体参数", required = true, dataType = "userInfo", paramType = "body")
	@RequestMapping(value = "/addUserInfo", method = RequestMethod.POST)
	public Result addUserInfo(UserInfo userInfo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据ID删除一个用户实体")
	@ApiImplicitParam(name = "id", value = "用户ID", dataType = "int", required = true, paramType = "path")
	@RequestMapping(value = "/deleteUserInfoByUserId/{id}", method = RequestMethod.POST)
	public Result deleteUserInfoByUserId(@PathVariable("id") int id) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改一个用户")
	@ApiImplicitParam(name = "vo", value = "用户实体参数", required = true, dataType = "vo", paramType = "body")
	@RequestMapping(value = "/updateUserInfoByUserId", method = RequestMethod.POST)
	public Result updateUserInfoByUserId(UserInfoVo vo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("用户登录方法 ")
	@ApiImplicitParam(name = "userInfoVo", value = "用户实体参数", required = true, dataType = "userInfoVo", paramType = "body")
	@RequestMapping(value = "/userLoign", method = RequestMethod.POST)
	public Result userLogin(UserInfoVo userInfoVo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("修改用户自己的密码")
	@ApiImplicitParam(name = "userInfo", value = "用户实体参数", required = true, dataType = "userInfo", paramType = "body")
	@RequestMapping(value = "/userUpdatePwd", method = RequestMethod.POST)
	public Result userUpdatePwd(UserInfo userInfo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据角色ID 查询用户信息")
	@ApiImplicitParam(name = "userInfo", value = "用户实体参数", required = true, dataType = "userInfo", paramType = "body")
	@RequestMapping(value = "/selectUserInfoByRoleIds", method = RequestMethod.POST)
	public Result selectUserInfoByRoleIds(UserInfo userInfo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据传入类型修改一个用户的状态")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户ID", dataType = "int", required = true, paramType = "path"),
			@ApiImplicitParam(name = "changeType", value = "传入类型", dataType = "int", required = true, paramType = "path") })
	@RequestMapping(value = "/changeUserInfoStatus/{userId}/{changeType}", method = RequestMethod.POST)
	public Result changeUserInfoStatus(@PathVariable("userId") int userId, @PathVariable("changeType") int changeType) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("检查用户是否存在")
	@ApiImplicitParam(name = "userName", value = "用户名", dataType = "String", required = true, paramType = "path")
	@RequestMapping(value = "/checkUserName/{userName}", method = RequestMethod.GET)
	public Result checkUserName(@PathVariable("userName") String userName) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("根据用户ID 修改用户角色信息")
	@ApiImplicitParam(name = "vo", value = "用户实体参数", required = true, dataType = "vo", paramType = "body")
	@RequestMapping(value = "/updateUserRoleIdsByUserInfoId", method = RequestMethod.POST)
	public Result updateUserRoleIdsByUserInfoId(UserInfoVo vo) {
		return ResultGenerator.getSuccessResult("ok");
	}

	@ApiOperation("分页查询UserInfo列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "num", value = "页码", dataType = "int", required = true, paramType = "path"),
			@ApiImplicitParam(name = "size", value = "数量", dataType = "int", required = true, paramType = "path") })
	@RequestMapping(value = "/selectUserInfoListByPage/{num}/{size}", method = RequestMethod.GET)
	public Result selectUserInfoListByPage(@PathVariable("num") int num, @PathVariable("size") int size) {
		PageHelper.startPage(num, size);
		List<UserInfo> list = userInfoMapper.selectAll();
		PageInfo<UserInfo> page = new PageInfo<>(list);
		return ResultGenerator.getSuccessResult(page);
	}

	@ApiOperation("查询所有UserInfo数据")
	@RequestMapping(value = "/selectUserInfoList", method = RequestMethod.GET)
	public Result selectUserInfoList() {
		List<UserInfo> list = userInfoMapper.selectAll();
		return ResultGenerator.getSuccessResult(list);
	}
}
