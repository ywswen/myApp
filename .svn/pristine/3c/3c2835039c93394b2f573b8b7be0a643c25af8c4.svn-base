package com.yyy.design.designModel17.Observer.pull;
/**
 *   @类名： ConcreteSubject
 *   @描述： 跟推模型相比，有一点变化，就是调用通知观察者的方法的时候，不需要传入参数了。
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:55:28
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteSubject extends Subject{
	private String state;
	public String getState(){
		return state;
	}
	public void change(String newState){
		state = newState;
		System.out.println("主题状态为：" + state);
		//状态发生变化，通知各个注册观察者
		this.notifyAllObserver();
	}
}

