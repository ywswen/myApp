package com.yyy.design.designModel3.abstractfactory;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午04:57:56
 * 
 * @类说明 ：Cpu工厂类
 */
public class CpuFactory {
	public static Cpu createCpu(int type) {
		Cpu cpu = null;
		if (type == 1) {
			cpu = new IntelCpu(755);
		} else if (type == 2) {
			cpu = new AmdCpu(938);
		}
		return cpu;
	}
}
