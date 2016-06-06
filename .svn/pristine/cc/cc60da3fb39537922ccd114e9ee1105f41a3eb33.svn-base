package com.yyy.design.designModel17.Observer.concrept;

import junit.framework.TestCase;

/**
 *   @类名： Client
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:19:38
 *   @修改人：
 *   @修改时间：  
 **/
public class Client extends TestCase{
	public void testObserverModle(){
		//创建主题对象
		ConcreteSubject subject = new ConcreteSubject();
		//创建观察者对象
		Observer observer = new ConcreteObserver();
		//将观察者对象登记到主题对象中
		subject.attach(observer);
//		subject.detach(observer);
		//改变主题对象的状态
		subject.change("new state");
	}
}

