package com.yyy.design.designModel17.Observer.concrept;
/**
 *   @类名： ConcreteObserver
 *   @描述： 具体观察者模式
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:14:56
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteObserver implements Observer{
	private String observerState;
	public void update(String state){
		observerState = state;
		System.out.println("状态为：" + observerState);
	}
}

