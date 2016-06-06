package com.yyy.design.designModel1.staticfactorymethod;


/**
 * @author： 特种兵—AK47 
 * @创建时间：2012-6-18 下午02:28:02
 * 
 * @类说明 ：工厂类
 */
public class LoginManager {
	public Login factory(String type) {
		if (type.equals("password")) {

			System.out.println("您从工厂里拿的是：口令认证");
			return new PasswordLogin();

		} else if (type.equals("passcode")) {

			System.out.println("您从工厂里拿的是：域认证");
			return new DomainLogin();

		} else {
			/**
			 * 这里抛出一个自定义异常会更恰当
			 */
			throw new RuntimeException("没有找到登录类型");
		}
	}
}
