package com.yyy.design.designModel9.decorator.Decorator;

/**
 *   @类名： ConcreteDecoratorB
 *   @描述： 具体装饰角色
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-22 上午11:18:52
 *   @修改人：
 *   @修改时间：  
 **/
public class ConcreteDecoratorB extends Decorator{

	public ConcreteDecoratorB(Component component) {
		super(component);
	}
	public void simpleOperation(){
		super.simpleOperation();
		//写相关业务代码
	} 
}
