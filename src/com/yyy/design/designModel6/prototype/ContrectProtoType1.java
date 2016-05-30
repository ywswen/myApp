package com.yyy.design.designModel6.prototype;

public class ContrectProtoType1 implements Prototype{
	//复制方法
	public Prototype clone(){
		Prototype prototype =new ContrectProtoType1();
		return prototype;
		
	};
}
