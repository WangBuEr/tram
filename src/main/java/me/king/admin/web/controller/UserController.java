package me.king.admin.web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import me.king.admin.domain.Role;
import me.king.admin.domain.User;
import me.king.admin.service.UserService;
import me.king.admin.util.ConfigProperties;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;
import me.king.util.qiniu.QiNiuUtil;
@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private ConfigProperties config;
	@Resource
	private UserService userService;
	@RequiresRoles(value = { "admin"})
	@RequestMapping("manager")
	public ModelAndView manager(){
		ModelAndView result = new ModelAndView();
		result.setViewName("user/manager");
		return result;
	}
	
	@RequestMapping("info/{userId}")
	public ModelAndView info(@PathVariable Long userId){
		ModelAndView result = new ModelAndView();
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		if(currentUser.getId().equals(userId)){
			result.addObject("user", userService.detail(userId));
			result.setViewName("user/info");
		}else{
			result.setViewName("redirect:/error/401");
		}
		return result;
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<User> query(User queryParam){
		DataTablesRsp<User> result = new DataTablesRsp<>(queryParam.getDraw());
		List<User> datas =  userService.queryList(queryParam);
		int count =  userService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "addOrUpdate", method = RequestMethod.GET)
	public ModelAndView addOrUpdate(Long userId){
		ModelAndView result = new ModelAndView();
		if(userId != null){
			User user = userService.detail(userId);
			if(user != null){
				result.addObject("user", user);
				List<Role> userRoleList = user.getRoleList();
				result.addObject("userRoleList",JSONArray.toJSONString(userRoleList));
			}else{
				result.setViewName("redirect:/error/401");
				return result;
			}
		}else{
			result.addObject("userRoleList", "[]");
		}
		getUploadToken(result);
		result.setViewName("/user/addOrUpdate");
		return result;
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "addOrUpdate",method = RequestMethod.POST)
	@ResponseBody
	public BusinessExecutionResult addOrUpdate(String paramJson){
		User user = JSON.parseObject(paramJson, User.class);
		userService.addOrUpdate(user);
		return BusinessExecutionResult.success();
	}
	@RequestMapping("update")
	@ResponseBody
	public BusinessExecutionResult update(User user){
		User currentUser = (User) SecurityUtils.getSubject().getSession().getAttribute("user");
		user.setLoginName(currentUser.getLoginName());
		userService.update(user);
		return BusinessExecutionResult.success();
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("verifyLoginNameOnly")
	@ResponseBody
	public Map<String, Object> verifyLoginNameOnly(Long userId,String loginName){
		Map<String, Object> result = new HashMap<>();
		result.put("valid",userService.verifyLoginNameOnly(userId, loginName));
		return result;
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{userId}",method = RequestMethod.DELETE)
	@ResponseBody
	public BusinessExecutionResult delete(@PathVariable Long userId){
		User user = userService.detail(userId);
		if(user != null && user.getLoginName().equals(SecurityUtils.getSubject().getPrincipal())){
			return BusinessExecutionResult.illegalOperation("不能删除自己！");
		}else{
			userService.delete(userId);
			return BusinessExecutionResult.success();
		}
	}
	
	private void getUploadToken(ModelAndView result) {
		QiNiuUtil qiNiuUtil = QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey());
		result.addObject("uploadToken", qiNiuUtil.getUpToken(config.getQiNiuBucketName()));
	}
}
