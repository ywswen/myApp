package com.yyy.design.designModel11.flyweight.complex;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *   @类名： FlyweightFactory
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-30 下午02:53:35
 *   @修改人：
 *   @修改时间：  
 **/
public class FlyweightFactory {
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
	/**
	 *   @生成时间： 2012-11-30 下午03:02:40
	 *   @方法说明： 
	 *   @参数： 单纯享元工厂方法
	 *   @返回值： 
	 *   @异常：
	 **/
	public Flyweight factory(Character state){
		Flyweight  fly = files.get(state);
		if(fly == null){
			fly = new ConcreteFlyweight(state);
			files.put(state, fly);
		}
		return fly;
	}
	/**
	 *   @生成时间： 2012-11-30 下午03:12:10
	 *   @方法说明： 复合享元方法
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public Flyweight factory(List<Character> compositeState){
		ConcreteCompositeFlyweight fly = new ConcreteCompositeFlyweight();
		for(Character state:compositeState){
			fly.add(state, this.factory(state));
		}
		return fly;
	}
}

