package com.yyy.design.designModel4.singletonmodel;

public class Singleton {
	private volatile static Singleton instance = null;
	/**
	 * 
	 * 私有默认构造子 
	 */
	private Singleton(){}
	/**
	 * 静态工厂方法 
	 * @return
	 */
	public static Singleton getInstace() {
		//先检查实例是否存在，如果不存在才进入下面的同步块  
		if(instance==null){
			 //同步块，线程安全的创建实例   
			synchronized(Singleton.class){
				//再次检查实例是否存在，如果不存在才真正的创建实例   
				if(instance==null){
					instance=new Singleton();
				}
			}
		}
		return instance;
	}
}
