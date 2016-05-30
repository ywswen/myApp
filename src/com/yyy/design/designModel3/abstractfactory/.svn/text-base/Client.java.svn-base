package com.yyy.design.designModel3.abstractfactory;


import org.junit.Test;

/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午05:01:04
 * 
 * @类说明 ：客户测试类
 */
public class Client {

	@Test
	public void test() {
		// 创建装机工程师对象
		ComputerEngineer cf = new ComputerEngineer();
		// 客户选择并创建需要使用的产品对象
		AbstractFactory af = new AmdFactory();
		// 告诉装机工程师自己选择的产品，让装机工程师组装电脑
		cf.makeComputer(af);
	}
}
