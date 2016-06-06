package com.yyy.design.designModel11.flyweight;
/**
 *   @类名： ConcreteFlyweight
 *   @描述： 构件享元角色
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-27 下午01:59:24
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteFlyweight implements Flyweight{
	private Character intrinsicState =null;
	/**
	 *   @作者： 杨文胜
	 *   @生成时间： 2012-11-28 上午10:51:53
	 *   @修改人：
	 *   @修改时间： 
	 *   @方法描述： 构造函数，内蕴状态作为参数传入
	 *   @param
	 **/
	public ConcreteFlyweight(Character state) {
		this.intrinsicState = state;
	}
	/**
	 *   @生成时间： 2012-11-28 上午10:52:32
	 *   @方法说明： 蕴状态作为参数传入方法中，改变方法的行为， 但是并不改变对象的内蕴状态。
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void operation(String state) {
		System.out.println("Intrinsic State = " + this.intrinsicState);  
        System.out.println("Extrinsic State = " + state);  
	}
}

