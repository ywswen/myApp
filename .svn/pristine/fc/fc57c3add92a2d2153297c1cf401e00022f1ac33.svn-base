package com.yyy.design.designModel17.Observer.pull;

import java.util.ArrayList;
import java.util.List;

/**
 *   @类名： Subject
 *   @描述： 拉模型的抽象主题类主要的改变是notifyAllObserver()方法。在循环通知观察者的时候，也就是循环调用观察者的update()方法的时候，
 *      	传入的参数不同了。
 *   @作者： 杨文胜
 *   @生成时间： 2013-5-13 下午03:44:38
 *   @修改人：
 *   @修改时间：  
 **/
public class Subject {
	//用来保存注册的观察者对象
	private List<Observer> list = new ArrayList<Observer>();
	/**
	 *   @生成时间： 2013-5-13 下午03:48:43
	 *   @方法说明： 注册观察者对象
	 *   @参数：		observer：观察者对象
	 *   @返回值： 
	 *   @异常：
	 **/
	public void attach(Observer observer){
		list.add(observer);
		System.out.println("Attached an Observer");
	}
	/**
	 *   @生成时间： 2013-5-13 下午03:50:04
	 *   @方法说明： 删除观察者对象
	 *   @参数：		observer：观察者对象
	 *   @返回值： 
	 *   @异常：
	 **/
	public void detach(Observer observer){
		list.remove(observer);
		System.out.println("Detached an Observer");
	}
	/**
	 *   @生成时间： 2013-5-13 下午03:54:16
	 *   @方法说明： 通知所有注册的观察者对象
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void notifyAllObserver(){
		for(Observer observer : list){
			observer.update(this);
		}
	}
}

