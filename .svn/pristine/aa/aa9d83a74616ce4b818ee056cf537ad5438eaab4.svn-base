package com.yyy.design.designModel17.Observer.pull;
/**
 *   @类名： ConcreteObserver
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:59:44
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteObserver implements Observer{
	/**
	 * @属性说明：观察者的状态
	 **/
	private String observerState;
	/**
	 *   @生成时间： 2013-5-13 下午04:02:23
	 *   @方法说明： 更新观察者的状态，使其与目标的状态保持一致
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void update(Subject subject) {
		this.observerState = ((ConcreteSubject)subject).getState();
		System.out.println("观察者状态为：" + observerState);
	}
}

