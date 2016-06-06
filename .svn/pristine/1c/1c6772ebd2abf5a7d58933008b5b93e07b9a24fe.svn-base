package com.yyy.project.cache.memcache.impl;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

import com.yyy.project.cache.memcache.ToftCache;

/**
 *   @类名： EhCacheImpl
 *   @描述： ehcache缓存实现类
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午10:34:29
 *   @修改人：
 *   @修改时间：  
 **/
public class EhCacheImpl implements ToftCache {
	
	private static Logger log = Logger.getLogger(EhCacheImpl.class);
	
	/**
	 * @属性说明：资源文件存储路径
	 **/
	private static String cacheConfigFilePath = "/resources/cache/ehcache.xml";
	
	/**
	 * @属性说明：ehcache实现对象
	 **/
	private static EhCacheImpl ehcache = null;
	
	/**
	 * @属性说明：缓存管理对象
	 **/
	private static CacheManager cacheManage = null;
	
	public static EhCacheImpl getInstance(){
		if(null == ehcache){
			ehcache = new EhCacheImpl();
			URL url = EhCacheImpl.class.getResource(cacheConfigFilePath);
			cacheManage = CacheManager.create(url);
		}
		return ehcache;
	}
	
	/**
	 *   @生成时间： 2013-2-17 上午11:04:16
	 *   @方法说明： 获取对象
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public Object getObject(String key, String cacheType) {
		Object obj;
		try {
			Cache ch = cacheManage.getCache(cacheType);
			obj = ch.get(key).getObjectValue();
		} catch (Exception e) {
			log.error("[" + key + "] Not Exist. " + e.getMessage());
			return null;
		}
		return obj;
	}

	
	/**
	 *   @生成时间： 2013-2-17 上午11:04:26
	 *   @方法说明：  存储缓存对象
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void setObject(String key, Object saveobj, String cacheType) {
		Cache ch = cacheManage.getCache(cacheType);
		ch.put(new Element(key, saveobj));
	}
	

	/**
	 *   @生成时间： 2013-2-17 上午11:04:39
	 *   @方法说明： 获取所有缓存数据键
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public List<String> getAllCacheName(String cacheType) {
		List<String> nameList = new ArrayList<String>();
		Iterator itor = cacheManage.getCache(cacheType).getKeys().iterator();
		while (itor.hasNext()) {
			nameList.add(String.valueOf(itor.next()));
		}
		return nameList;
	}
	
	/**
	 *   @生成时间： 2013-2-17 上午11:05:00
	 *   @方法说明： 结束缓存
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void shutdownCache(){
		if(null != cacheManage)
			cacheManage.shutdown();
		else
			log.error("停止缓存失败，缓存对象已不存在！");
	}
}
