package com.yyy.design.designModel4.singletonmodel;

public class LazySingleton  {
	private static LazySingleton instance = null;
	/**
	 * 
	 * 私有默认构造子 
	 */
	private  LazySingleton(){}
	/**
	 * 静态工厂方法 
	 * @return
	 */
	public static synchronized  LazySingleton getInstanc(){
		if(instance==null){
			instance=new LazySingleton();
		}
		return instance;
	}
}
