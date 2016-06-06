package com.yyy.design.designModel17.Observer.concrept;
/**
 *   @类名： ConcreteSubject
 *   @描述： 具体主题角色
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:10:30
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteSubject extends Subject{
	/**
	 * @属性说明：
	 **/
	private String state;
	
	public String getState(){
		return state;
	}
	public void change(String newState){
		this.state = newState;
		System.out.println("主题状态为：" + state);
		//通知注册观察者更新状态
		this.notifyAllObserver(newState);
	}
}

