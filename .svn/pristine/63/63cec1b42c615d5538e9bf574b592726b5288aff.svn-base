package com.yyy.design.designModel5.builderfactory;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-25 上午10:12:29
 * 
 * @类说明 ：客户端类Client
 */
public class Client {
	public static void main(String[] args) {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		Product product = builder.retrieveResult();
		System.out.println(product.getPart1());
		System.out.println(product.getPart2());
	}
}
