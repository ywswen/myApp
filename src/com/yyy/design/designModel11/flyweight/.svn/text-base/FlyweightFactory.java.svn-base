package com.yyy.design.designModel11.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 *   @类名： FlyweightFactory
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-28 上午11:05:54
 *   @修改人：
 *   @修改时间：  
 **/
public class FlyweightFactory {
	private Map<Character, Flyweight> files = new HashMap<Character, Flyweight>();
//	public FlyweightFactory(Map<Character, Flyweight> files) {
//		this.files = files;
//	}
	public Flyweight factory(Character state){
		// 先从缓存中查找对象   
		Flyweight flyweight = files.get(state);
		if(flyweight == null){
			// 如果对象不存在则创建一个新的Flyweight对象   
			flyweight = new ConcreteFlyweight(state);
			// 把这个新的Flyweight对象添加到缓存中
			files.put(state, flyweight);
		}else{
			System.out.println(state + "-->状态对象已经存在");
		}
		
		return flyweight;
	}
}

