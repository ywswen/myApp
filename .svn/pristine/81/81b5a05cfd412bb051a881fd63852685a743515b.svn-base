package com.yyy.design.designModel15.strategy.bookstategy;

import junit.framework.TestCase;

/**
 *   @类名： ClientTest
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-12-7 上午11:20:26
 *   @修改人：
 *   @修改时间：  
 **/
public class ClientTest extends TestCase{
	public void testBookStrategy(){
		//初级会员
		MemberStrategy memStrategy = new PrimaryMemberStrategy();
		Price price = new Price(memStrategy);
		double rmb= 100;
		System.out.println(price.quote(rmb));
		//中级会员
		memStrategy = new InterMediateMemberStrategy();
		price = new Price(memStrategy);
		System.out.println(price.quote(rmb));
		//高级会员
		memStrategy = new AdvancedMemberStrategy();
		price = new Price(memStrategy);
		System.out.println(price.quote(rmb));
	}
}

