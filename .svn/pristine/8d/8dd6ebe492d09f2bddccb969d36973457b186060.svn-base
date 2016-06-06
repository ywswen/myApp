package com.yyy.project.listener.impl;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import com.yyy.dailycode.exception.loadproperties.LoadErrorProperties;
import com.yyy.project.cache.memcache.CacheType;
import com.yyy.project.cache.memcache.ToftCache;
import com.yyy.project.cache.memcache.impl.ToftCacheFactoryImpl;
import com.yyy.project.listener.ToftContextListener;

/**
 *   @类名： MyServletContextListener
 *   @描述： 个人初始化类
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午11:57:39
 *   @修改人：
 *   @修改时间：  
 **/
public class MyServletContextListener implements ToftContextListener {

	/**
	 *   @生成时间： 2016-1-1 上午11:59:04
	 *   @方法说明： 销毁
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void contextDestroyed(ServletContextEvent servletcontextevent) {
		
	}

	/**
	 *   @生成时间： 2016-1-1 上午11:59:13
	 *   @方法说明： 初始化
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void contextInitialized(ServletContextEvent servletcontextevent) {
		ToftCache cache = new ToftCacheFactoryImpl().createEhcache();
		Iterator<?> it = LoadErrorProperties.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<?, ?> entry = (Map.Entry<?, ?>) it.next();
			String key = entry.getKey().toString();
			Object value = entry.getValue();
//			System.out.println(key + ":" + value);
			cache.setObject(key, value, CacheType.CACHETYPE_EH_FOREVER);
			servletcontextevent.getServletContext().setAttribute(key, value);
		}
//		Map<String, String> ddMap = new HashMap<String, String>();
//		ddMap.put("ddd", "哈哈");
//		servletcontextevent.getServletContext().setAttribute("mapf", ddMap);
		System.out.println("123");
	}

}
