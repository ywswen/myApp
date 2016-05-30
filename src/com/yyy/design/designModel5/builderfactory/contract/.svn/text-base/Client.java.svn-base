package com.yyy.design.designModel5.builderfactory.contract;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-25 下午02:56:56
 * 
 * @类说明 ：客户端类
 */
public class Client {
	public static void main(String[] args) {
		// 创建构建器对象
		InsuranceContract.ConcreteBuilder builder = new InsuranceContract.ConcreteBuilder("9527", 123L, 456L);
		// 设置需要的数据，然后构建保险合同对象
//		InsuranceContract contract = builder.setPersonName("特种兵-Ak47").setOtherData("test").build();
		InsuranceContract contract = builder.setCompanyName("神州数码").setOtherData("test").build();
		// 操作保险合同对象的方法
		contract.someOperation();
	}
}
