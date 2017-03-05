package me.king.admin.web.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.king.admin.service.ResourceService;
import me.king.admin.web.vo.BusinessExecutionResult;
@Controller
@RequestMapping("resource")
public class ResourceController {
	@Resource
	private ResourceService resourceService;
	@RequiresRoles(value = { "admin"})
	@RequestMapping("manager")
	public String manager(){
		return "/resource/manager";
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("queryAll")
	@ResponseBody
	public BusinessExecutionResult queryAll(){
		return BusinessExecutionResult.success(resourceService.queryAll());
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("addOrUpdate")
	@ResponseBody
	public BusinessExecutionResult addOrUpdate(me.king.admin.domain.Resource res){
		resourceService.addOrUpdate(res);
		return BusinessExecutionResult.success();
		
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{resId}",method = RequestMethod.GET)
	@ResponseBody
	public BusinessExecutionResult info(@PathVariable("resId")Long resId){
		return BusinessExecutionResult.success(resourceService.query(resId));
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{resId}",method = RequestMethod.DELETE)
	@ResponseBody
	public BusinessExecutionResult delete(@PathVariable("resId")Long resId){
		resourceService.delete(resId);
		return BusinessExecutionResult.success();
	}
}
