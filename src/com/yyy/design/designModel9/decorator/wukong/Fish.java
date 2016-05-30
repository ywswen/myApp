package com.yyy.design.designModel9.decorator.wukong;

/**
 *   @类名： Fish
 *   @描述： 具体装饰角色“鱼儿”
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 上午09:43:56
 *   @修改人：
 *   @修改时间：  
 **/
public class Fish extends Change{

	public Fish(TheGreatestSage sage) {
		super(sage);
		// TODO Auto-generated constructor stub
	}
	public void move(){
		System.out.println("Fish move");
	}
}
