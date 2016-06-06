package com.yyy.design.designModel11.flyweight.complex;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

/**
 *   @类名： Client
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-30 下午03:12:38
 *   @修改人：
 *   @修改时间：  
 **/
public class ClientTest extends TestCase{
	/**
	 *   @生成时间： 2012-11-30 下午03:29:17
	 *   @方法说明： junit 测试单纯享元模式和复合享元模式是否可以共享对象
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void testCompositeFlyweight(){
		Character c = new Character('a');
		FlyweightFactory flyweightFactory = new FlyweightFactory();
		
		List<Character>compositeState = new ArrayList<Character>();
		compositeState.add(new Character('a'));
		compositeState.add(new Character('b'));
		compositeState.add(new Character('c'));
		compositeState.add(new Character('d'));
		Flyweight flyComposite1 = flyweightFactory.factory(compositeState);
		Flyweight flyComposite2 = flyweightFactory.factory(compositeState);
 		System.out.println("复合享元模式是否可以共享对象：" + (flyComposite1 == flyComposite2));
 		flyComposite1.operation("Composite all");
 		Flyweight fly1 = flyweightFactory.factory(c);
 		Flyweight fly2 = flyweightFactory.factory(c);
 		System.out.println("单纯享元模式是否可以共享对象：" + (fly1 == fly2));
	}
}

