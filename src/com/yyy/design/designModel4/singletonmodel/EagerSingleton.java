package com.yyy.design.designModel4.singletonmodel;

public class EagerSingleton {
	private static EagerSingleton instance = new EagerSingleton();
	/**
	 * 
	 * 私有默认构造子 
	 */
	private EagerSingleton(){}
	/**
	 * 静态工厂方法 
	 * @return
	 */
	public static EagerSingleton getInstace() {
		return instance;
	}
}
