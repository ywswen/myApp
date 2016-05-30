package com.yyy.design.designModel3.abstractfactory;

public class AmdFactory implements AbstractFactory{
	public Cpu createCpu(){
		return new AmdCpu(938);
	}
	public Mainboard createMainboard(){
		return new AmdMainboard(938);
	}
}
