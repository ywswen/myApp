package com.yyy.design.designModel11.flyweight;

import junit.framework.TestCase;

/**
 *   @类名： ClientTest
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-28 上午11:33:00
 *   @修改人：
 *   @修改时间：  
 **/
public class ClientTest extends TestCase{
	public void testFlyweight(){
		FlyweightFactory factory  = new FlyweightFactory();
		Flyweight flyweight = factory.factory(new Character('a'));
		flyweight.operation("First call");
		flyweight = factory.factory(new Character('b'));
		flyweight.operation("Second call");
		flyweight = factory.factory(new Character('a'));
		flyweight.operation("Third call");
		
		
	}
}

