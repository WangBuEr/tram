package me.king.admin.web.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import me.king.admin.service.UserService;
import me.king.admin.web.vo.BusinessExecutionResult;

@Controller
public class MainController extends BaseController{
	@Resource
	private UserService userService;
	@RequestMapping("index")
	public ModelAndView index(ModelMap model){
		ModelAndView result = new ModelAndView();
		result.addObject("user", getCurrentUser());
		result.setViewName("index");
		return result;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "login")
	public String login(){
		if (SecurityUtils.getSubject().isAuthenticated()) {
            return "redirect:/index";
        }
		return "login";
	}
	@RequestMapping(method = RequestMethod.POST,value = "login")
	@ResponseBody
	public BusinessExecutionResult login(String loginName,String password,Integer rememberMe){
		if(!StringUtils.hasText(loginName)){
			return BusinessExecutionResult.paramError("用户名不能为空!");
		}
		if(!StringUtils.hasText(password)){
			return BusinessExecutionResult.paramError("密码不能为空!");
		}
		Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(loginName, password);
        // 设置记住密码
        token.setRememberMe(1 == rememberMe);
        try {
            user.login(token);
            user.getSession().setAttribute("user", userService.detail(user.getPrincipal().toString()));
            return BusinessExecutionResult.success();
        } catch (UnknownAccountException e) {
        	return BusinessExecutionResult.illegalOperation("账号不存在！");
        } catch (DisabledAccountException e) {
        	return BusinessExecutionResult.illegalOperation("账号未启用！");
        } catch (IncorrectCredentialsException e) {
        	return BusinessExecutionResult.illegalOperation("密码错误！");
        } 
	}
	@RequestMapping("logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "/login";
	}
}
