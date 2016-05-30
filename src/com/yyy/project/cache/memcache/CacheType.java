package com.yyy.project.cache.memcache;

/**
 *   @类名： CacheType
 *   @描述： 缓存类型定义
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午10:30:37
 *   @修改人：
 *   @修改时间：  
 **/
public interface CacheType {
	/** 
	  * @Fields CACHETYPE_EH_FOREVER : ehcache的永久缓存 
	  */ 
	public static final String CACHETYPE_EH_FOREVER = "eh.forever";
	
	/** 
	  * @Fields CACHETYPE_EH_TENMS : ehcache十分钟缓存
	  */ 
	public static final String CACHETYPE_EH_TENMS = "eh.tenms";
	
	/** 
	  * @Fields CACHETYPE_EH_THIRTYMS : ehcache三十分钟缓存
	  */ 
	public static final String CACHETYPE_EH_THIRTYMS = "eh.thirtyms";
}
