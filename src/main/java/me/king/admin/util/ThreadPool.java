package me.king.admin.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import lombok.Getter;
/**
 * 
 *@Title:  
 *@Description:  线程池
 *@Author:BuEr  
 *@Since:2016年9月1日  
 *@Version:1.1.0
 */
@Getter
public final class ThreadPool {
	public static final ExecutorService pool;
	static{
		pool = new ThreadPoolExecutor(2, 4, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(20));
	}
}
