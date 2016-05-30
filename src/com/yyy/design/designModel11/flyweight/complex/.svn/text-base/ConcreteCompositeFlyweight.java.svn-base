package com.yyy.design.designModel11.flyweight.complex;

import java.util.HashMap;
import java.util.Map;

/**
 *   @类名： ConcreteCompositeFlyweight
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-30 下午02:08:40
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteCompositeFlyweight implements Flyweight{
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	public void add(Character c, Flyweight f){
		files.put(c, f);
	}
	/**
	 *   @生成时间： 2012-11-30 下午02:15:14
	 *   @方法说明： 外蕴状态作为参数传入方法中
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void operation(String state) {
		Flyweight flyweight = null;
		for(Object o:files.keySet()){
			flyweight = files.get(o);
			flyweight.operation(state);
		}
		
	}

}

