package com.yyy.design.designModel5.builderfactory;

 /**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-25 上午10:09:13
 * 
 * @类说明 ：抽象建造者类Builder
 */
/**
 * @author admin
 * 在什么情况下使用建造模式
　　1. 需要生成的产品对象有复杂的内部结构，每一个内部成分本身可以是对象，也可以仅仅是一个对象（即产品对象）的一个组成部分。

　　2. 需要生成的产品对象的属性相互依赖。建造模式可以强制实行一种分步骤进行的建造过程，因此，如果产品对象的一个属性必须在另一个属性被赋值之后才可以被赋值，使用建造模式是一个很好的设计思想。

　　3. 在对象创建过程中会使用到系统中的其他一些对象，这些对象在产品对象的创建过程中不易得到。


 */
public interface Builder {
	public void buildPart1();

	public void buildPart2();

	public Product retrieveResult();
}