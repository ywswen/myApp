package com.yyy.design.designModel10.proxy.dynamicproxy;

import junit.framework.TestCase;

/**
 *   @类名： ServiceTest
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 下午05:48:48
 *   @修改人：
 *   @修改时间：  
 **/
public class ServiceTest extends TestCase{
	public void testDynamicProsy(){
		ServiceImpl target = new ServiceImpl();
		ServiceProxy proxy = new ServiceProxy(target);
		IService service = (IService)proxy.getProxyInstance();
		String date = service.queryDate();
		System.out.println(date);
		int plusValue = service.sub(20, 10);
		System.out.println("20-10 = " + plusValue);
	}
}

