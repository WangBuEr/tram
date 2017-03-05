package me.king.admin.web.controller;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.king.admin.domain.Organization;
import me.king.admin.service.OrganizationService;
import me.king.admin.web.vo.BusinessExecutionResult;

@RequestMapping("organization")
@Controller
public class OrganizationController {
	@Resource
	private OrganizationService orgService;
	@RequiresRoles(value = { "admin"})
	@RequestMapping("manager")
	public String manager(){
		return "/organization/manager";
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("queryAll")
	@ResponseBody
	public BusinessExecutionResult queryAll(){
		return BusinessExecutionResult.success(orgService.queryAll());
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("addOrUpdate")
	@ResponseBody
	public BusinessExecutionResult addOrUpdate(Organization org){
		orgService.addOrUpdate(org);
		return BusinessExecutionResult.success();
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{orgId}",method = RequestMethod.GET)
	@ResponseBody
	public BusinessExecutionResult info(@PathVariable("orgId")Long orgId){
		return BusinessExecutionResult.success(orgService.query(orgId));
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{orgId}",method = RequestMethod.DELETE)
	@ResponseBody
	public BusinessExecutionResult delete(@PathVariable("orgId")Long orgId){
		orgService.delete(orgId);
		return BusinessExecutionResult.success();
	}
}
