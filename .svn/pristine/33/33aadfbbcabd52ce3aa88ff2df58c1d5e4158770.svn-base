package com.yyy.project.cache.memcache.impl;

import com.yyy.project.cache.memcache.CacheType;
import com.yyy.project.cache.memcache.ToftCache;
import com.yyy.project.cache.memcache.ToftCacheFactory;

/**
 *   @类名： ToftCacheFactoryImpl
 *   @描述： 缓存工厂实现类
 *   @作者： 杨文胜
 *   @生成时间： 2016-1-1 上午10:34:20
 *   @修改人：
 *   @修改时间：  
 **/
public class ToftCacheFactoryImpl implements ToftCacheFactory{

	public ToftCache createEhcache() {
		return EhCacheImpl.getInstance();
	}

	public static void main(String[] args) {
//		new ToftCacheFactoryImpl().createTreecache().setObject("1234", "1232434", null);
//		
//		System.out.println(new ToftCacheFactoryImpl().createTreecache().getObject("1234", null));
		
		ToftCache cache = new ToftCacheFactoryImpl().createEhcache();
		
//		cache.setObject("123411", "1234451", CacheType.CACHETYPE_EH_FOREVER);
		
		System.out.println(cache.getObject("123411", CacheType.CACHETYPE_EH_FOREVER));
		
		cache.shutdownCache();
	}
}
