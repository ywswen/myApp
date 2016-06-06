package com.yyy.design.designModel1.staticfactorymethod;


import org.junit.Test;

/**
 * @author： 特种兵—AK47 
 * @创建时间：2012-6-18 下午02:31:41
 * 
 * @类说明 ：测试工厂类
 */
public class TestFactory {

	@Test
	public void testFactory() {
		// TODO Auto-generated method stub
		String loginType = "password";
		String name = "name";
		String password = "password";
		Login login = new LoginManager().factory(loginType);
		boolean bool = login.verify(name, password);
		if (bool) {
			/**
			 * 业务逻辑
			 */
		} else {
			/**
			 * 业务逻辑
			 */
		}
	}
}