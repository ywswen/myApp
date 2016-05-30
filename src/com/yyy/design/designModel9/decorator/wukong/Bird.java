package com.yyy.design.designModel9.decorator.wukong;

/**
 *   @类名： Bird
 *   @描述： 具体装饰角色“鸟儿”
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 上午09:43:28
 *   @修改人：
 *   @修改时间：  
 **/
public class Bird extends Change {

	public Bird(TheGreatestSage sage) {
		super(sage);
	}

	public void move() {
		System.out.println("Bird move");
	}
}
