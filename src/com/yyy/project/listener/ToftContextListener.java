package com.yyy.project.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *   @类名： ToftContextListener
 *   @描述： 上下文监听接口
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午11:49:38
 *   @修改人：
 *   @修改时间：  
 **/
public interface ToftContextListener extends ServletContextListener {

	/**
	 *   @生成时间： 2016-1-1 上午11:56:15
	 *   @方法说明： 销毁
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void contextDestroyed(ServletContextEvent servletcontextevent);

	/**
	 *   @生成时间： 2016-1-1 上午11:56:17
	 *   @方法说明： 初始化
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void contextInitialized(ServletContextEvent servletcontextevent);
}
