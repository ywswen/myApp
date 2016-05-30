package com.yyy.design.designModel11.flyweight.complex;
/**
 *   @类名： ConcreteFlyweight
 *   @描述： 具体享元角色
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-30 下午02:02:45
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteFlyweight implements Flyweight{
	private Character intrinsicSate = null;
	/**
	 *   @作者： 杨文胜
	 *   @生成时间： 2012-11-30 下午02:05:32
	 *   @修改人：
	 *   @修改时间： 
	 *   @方法描述： 构造函数，内蕴状态作为参数传入
	 *   @param
	 **/
	public ConcreteFlyweight(Character intrinsicState) {
		this.intrinsicSate = intrinsicState;
	}
	/**
	 *   @生成时间： 2012-11-30 下午02:07:22
	 *   @方法说明： 外蕴状态作为参数传入方法中，改变方法的行为，但是不改变内蕴状态
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void operation(String state) {
		System.out.println("Intrinsic state = " + this.intrinsicSate);
		System.out.println("Extrinsic state = " + state);
		
	}
}

