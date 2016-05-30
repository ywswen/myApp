package com.yyy.project.servlet.initserver;

import org.springframework.context.ApplicationContext;

/**
 *   @类名： SinoDataInitServer
 *   @描述： 需要初始化执行的服务
 *   @作者： 杨文胜
 *   @生成时间： 2013-2-17 上午11:01:14
 *   @修改人： 
 *   @修改时间：  
 **/
public interface IToftInitServer {
	
	/**
	 *   @生成时间： 2013-2-17 上午11:01:30
	 *   @方法说明： 执行服务
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public boolean execute(ApplicationContext appctx);
	
	/**
	 *   @生成时间： 2013-3-9 下午09:16:53
	 *   @方法说明： 需要销毁的对象
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void destroy();
}
