package me.king.admin.web.controller;

import org.apache.shiro.SecurityUtils;

import me.king.admin.domain.User;

public abstract class BaseController {
	protected User getCurrentUser(){
		return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
	}
}
