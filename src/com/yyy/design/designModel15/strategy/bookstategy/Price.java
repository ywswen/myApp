package com.yyy.design.designModel15.strategy.bookstategy;
/**
 *   @类名： Price
 *   @描述： 价格类
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-7 上午11:05:11
 *   @修改人：
 *   @修改时间：  
 **/
public class Price {
	/**
	 * @属性说明：持有一个具体的策略对象
	 **/
	private MemberStrategy memStrategy;
	/**
	 *   @作者： 杨文胜
	 *   @生成时间： 2012-12-7 上午11:08:17
	 *   @修改人：
	 *   @修改时间： 
	 *   @方法描述： 具体的
	 *   @param  构造函数，传入一个具体的策略对象：memStrategy
	 **/
	public Price(MemberStrategy memStrategy) {
		this.memStrategy = memStrategy;
	}
	/**
	 *   @生成时间： 2012-12-7 上午11:11:03
	 *   @方法说明： 计算图书的价格
	 *   @参数：		图书原来的价格
	 *   @返回值： 	计算打折后的图书的价格
	 *   @异常：
	 **/
	public double quote(double bookPrice){
		return this.memStrategy.calcPrice(bookPrice);
	}
}

