package com.yyy.design.designModel17.Observer.concrept;

import java.util.ArrayList;
import java.util.List;

/**
 *   @类名： Subject
 *   @描述： 抽象主题角色
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午02:58:02
 *   @修改人：
 *   @修改时间：  
 **/
public abstract class Subject {
	/**
	 * @属性说明：用来保存注册的观察者对象
	 **/
	private List<Observer> list = new ArrayList<Observer>();
	/**
	 *   @生成时间： 2013-5-13 下午03:04:00
	 *   @方法说明： 注册观察者对象
	 *   @参数：	observer ： 观察者对象
	 *   @返回值： 
	 *   @异常：
	 **/
	public void attach(Observer observer){
		list.add(observer);
		System.out.println("Attached an Observer!");
	}
	/**
	 *   @生成时间： 2013-5-13 下午03:06:13
	 *   @方法说明： 删除观察者对象
	 *   @参数：		observer ：观察者对象
	 *   @返回值： 
	 *   @异常：
	 **/
	public void detach(Observer observer){
		list.remove(observer);
		System.out.println("Detach an Observer");
	}
	/**
	 *   @生成时间： 2013-5-13 下午03:08:38
	 *   @方法说明： 通知所有的注册观察者对象
	 *   @参数：		newState ： 新状态
	 *   @返回值： 
	 *   @异常：
	 **/
	public void notifyAllObserver(String newState){
		for(Observer observer : list){
			observer.update(newState);
		}
	}
}

