package me.king.admin.util;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import me.king.util.spring.BeanUtil;
/**
 * 
 *@Title:  
 *@Description:  邮件工具类
 *@Author:BuEr  
 *@Since:2016年8月31日  
 *@Version:1.1.0
 */
public final class EmailUtil {
	/**
	 * 
	 * @param to 接受人
	 * @param subject 主题
	 * @param text  邮件内容
	 * @Description: 发送邮件
	 */
	public static final void sendMail(String to,String subject,String text){
		JavaMailSenderImpl mailSender = BeanUtil.getBean(JavaMailSenderImpl.class);
		MimeMessage mailMsg = mailSender.createMimeMessage();
		try {
			MimeMessageHelper msgHelper = new MimeMessageHelper(mailMsg,true,"UTF-8");
			msgHelper.setTo(to);
			msgHelper.setFrom(mailSender.getUsername());
			msgHelper.setSubject(subject);
			msgHelper.setText(text,true);
			mailSender.send(mailMsg);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
