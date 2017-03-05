package me.king.admin.web.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import me.king.admin.domain.Role;
import me.king.admin.service.RoleService;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.admin.web.vo.DataTablesRsp;

@RequestMapping("role")
@Controller
public class RoleController {
	@Resource
	private RoleService roleService;
	@RequiresRoles(value = { "admin"})
	@RequestMapping("manager")
	public String manager(){
		return "/role/manager";
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("query")
	@ResponseBody
	public DataTablesRsp<Role> query(Role queryParam){
		DataTablesRsp<Role> result = new DataTablesRsp<>(queryParam.getDraw());
		List<Role> datas =  roleService.queryList(queryParam);
		int count =  roleService.queryCount(queryParam);
		result.setData(datas);
		result.setRecordsTotal(count);
		result.setRecordsFiltered(count);
		return result;
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{roleId}", method = RequestMethod.GET)
	@ResponseBody
	public BusinessExecutionResult get(@PathVariable("roleId")Long roleId){
		return BusinessExecutionResult.success(roleService.query(roleId));
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "{roleId}", method = RequestMethod.DELETE)
	@ResponseBody
	public BusinessExecutionResult delete(@PathVariable("roleId")Long roleId){
		roleService.delete(roleId);
		return BusinessExecutionResult.success();
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "roleResource/{roleId}")
	@ResponseBody
	public BusinessExecutionResult queryRoleResource(@PathVariable("roleId")Long roleId){
		return BusinessExecutionResult.success(roleService.queryRoleResource(roleId));
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping(value = "addOrUpdate")
	@ResponseBody
	public BusinessExecutionResult addOrUpdate(Role role){
		roleService.addOrUpdate(role);
		return BusinessExecutionResult.success();
	}
	@RequiresRoles(value = { "admin"})
	@RequestMapping("authorization/{roleId}")
	@ResponseBody
	public BusinessExecutionResult authorization(Long[] resList,@PathVariable Long roleId){
		roleService.authorization(resList, roleId);
		return BusinessExecutionResult.success();
	}
}
