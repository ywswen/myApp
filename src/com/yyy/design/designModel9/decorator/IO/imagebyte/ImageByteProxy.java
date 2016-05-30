package com.yyy.design.designModel9.decorator.IO.imagebyte;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *   @类名： ImageByteProxy
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-27 下午04:41:39
 *   @修改人：
 *   @修改时间：  
 **/
public class ImageByteProxy implements InvocationHandler{
	IImageByte ib;
	public ImageByteProxy(IImageByte ib) {
		this.ib = ib;
	}
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object result = null;
		if(!(ib instanceof ImageByteImpl)){
			System.out.println("不能代理对象");
		}else if(((ImageByteImpl)ib).ownMethod()){
			System.out.println("用户权限不足");
		}
		result = method.invoke(ib, args);
		// TODO Auto-generated method stub
		return result;
	}
	public Object getProxyInstance(){
		return Proxy.newProxyInstance(ib.getClass().getClassLoader(), ib.getClass().getInterfaces(), this);
	}
}

