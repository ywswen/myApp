package com.yyy.design.designModel10.proxy.proxy;

import junit.framework.TestCase;

/**
 *   @类名： Client
 *   @描述： Test类
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 下午05:14:38
 *   @修改人：
 *   @修改时间：  
 **/
public class Client extends TestCase{
	/**
	 *   @生成时间： 2012-11-26 下午05:21:17
	 *   @方法说明： 客户端：代理对象将客户端的调用委派给目标对象，在调用目标对象的方法之前跟之后都可以执行特定的操作。 
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testProxyModel(){
		AbstractObject ab = new ProxyObject();
		ab.operation();
		//父类的应用指向子类的对象，面向对象的多态性
		RealObject ro = new ProxyObject();
		ro.operation();
	}
}

