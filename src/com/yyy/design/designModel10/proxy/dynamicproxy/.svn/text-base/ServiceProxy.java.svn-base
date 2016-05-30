package com.yyy.design.designModel10.proxy.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *   @类名： ServiceProxy
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 下午05:35:04
 *   @修改人：
 *   @修改时间：  
 **/
public class ServiceProxy implements InvocationHandler{
	private Object target;
	public ServiceProxy(Object target) {
		this.target = target;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		if(!(target instanceof ServiceImpl)) {
			System.out.println("不能代理该对象");
			return result;
		}else if(!"admin".equals(((ServiceImpl)target).ownMethod())){
			System.out.println("权限不足");
			return result;
		}
		result = method.invoke(target, args);
		return result;
	}
	/**
	 *   @生成时间： 2012-11-26 下午05:45:00
	 *   @方法说明： 返回委托类的接口实例
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
}

