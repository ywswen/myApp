package com.yyy.design.designModel6.prototype.loginprototype;

import com.yyy.design.designModel6.prototype.loginprototype.ContrectProtoType2;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-25 下午04:55:39
 * 
 * @类说明 ： 客户端角色
 */
public class Client {
	public static void main(String[] args) {
		try {
			ProtoType p1 = new ContrectProtoType1();
			PrototypeManager.setPrototype("p1", p1);
			// 获取原型来创建对象
			ProtoType p3 = PrototypeManager.getPrototype("p1").clone();
			p3.setName("张三");
			System.out.println("第一个实例：" + p3);
			// 有人动态的切换了实现
			ProtoType p2 = new ContrectProtoType2();
			PrototypeManager.setPrototype("p1", p2);
			// 重新获取原型来创建对象
			ProtoType p4 = PrototypeManager.getPrototype("p1").clone();
			p4.setName("李四");
			System.out.println("第二个实例：" + p4);
			// 有人注销了这个原型
			PrototypeManager.removePrototype("p1");
			// 再次获取原型来创建对象
			ProtoType p5 = PrototypeManager.getPrototype("p1").clone();
			p5.setName("王五");
			System.out.println("第三个实例：" + p5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
