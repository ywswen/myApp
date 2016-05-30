package com.yyy.design.designModel10.proxy.proxy;
/**
 *   @类名： ProxyObject
 *   @描述： 代理对象角色
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 下午05:06:32
 *   @修改人：
 *   @修改时间：  
 **/
public class ProxyObject extends RealObject{
	private RealObject ro = new RealObject();
	public void operation(){
		System.out.println("before");
		ro.operation();
		System.out.println("after");
	}
}

