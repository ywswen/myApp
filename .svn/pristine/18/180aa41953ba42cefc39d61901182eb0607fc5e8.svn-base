package com.yyy.design.designModel4.singletonmodel;

public class TreadAndLazyInitializtionSingleton {
	
	private TreadAndLazyInitializtionSingleton(){}
	/** 
	 * 类级的内部类，也就是静态的成员式内部类，该内部类的实例与外部类的实例 
	 * 没有绑定关系，而且只有被调用到时才会装载，从而实现了延迟加载。
	 */  
	private static class InnerClassSingleton{
		//静态初始化器，由JVM来保证线程安全
		private static TreadAndLazyInitializtionSingleton instance = new TreadAndLazyInitializtionSingleton(); 
//		public TreadAndLazyInitializtionSingleton getInstance(){
//			instance = new TreadAndLazyInitializtionSingleton();
//			return instance;
	}
	@SuppressWarnings("static-access")
	public TreadAndLazyInitializtionSingleton getInstance(){
		return  new InnerClassSingleton().instance;
	}
}
