package me.king.admin.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import me.king.admin.util.ConfigProperties;
import me.king.admin.web.vo.BusinessExecutionResult;
import me.king.util.qiniu.QiNiuUtil;
@Controller
@RequestMapping("upload")
public class UploadController {
	@Resource
	private ConfigProperties config;
	@RequestMapping("getUploadToken")
	@ResponseBody
	public BusinessExecutionResult getUploadToken(){
		QiNiuUtil qiNiuUtil = QiNiuUtil.getInstance(config.getQiNiuAecretKey(), config.getQiNiuSecretKey());
		return BusinessExecutionResult.success(qiNiuUtil.getUpToken(config.getQiNiuBucketName()));
	} 
}
