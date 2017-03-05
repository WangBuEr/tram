package me.king.admin.util;

import me.king.util.encrypt.Des;
import me.king.util.spring.BeanUtil;

/**
 * 
 *@Title:  
 *@Description:  积分和钱转换器
 *@Author:BuEr  
 *@Since:2016年8月31日  
 *@Version:1.1.0
 */
public final class IntegralOrMoneyDecrypt {
	/**
	 * 
	 * @param data 需要解密的数据
	 * @return  解密之后的数据
	 * @Description: 解密之后的数据
	 */
	public static final Integer decrypt(String data){
		ConfigProperties configProperties = BeanUtil.getBean(ConfigProperties.class);
		return Integer.parseInt(Des.decrypt(data, configProperties.getDesKey()));
	}
}
