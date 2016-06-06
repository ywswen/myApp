package com.yyy.design.designModel9.decorator.wukong;

/**
 * @类名： Client
 * @描述：
 * @作者： 杨文胜
 * @生成时间： 2012-11-26 下午01:34:39
 * @修改人：
 * @修改时间：
 */
public class Client {
	public static void main(String[] args) {
		TheGreatestSage sage = new Monkey();
		//第一种写法
		TheGreatestSage fish =  new Fish(sage);
		TheGreatestSage bird = new Bird(sage);
		//第二种写法
		//TheGreatestSage fish = new Fish(new Bird(sage));
		fish.move();
		bird.move();
	}
}
