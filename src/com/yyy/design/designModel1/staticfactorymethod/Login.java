package com.yyy.design.designModel1.staticfactorymethod;

/**
 * @author： 特种兵—AK47 
 * @创建时间：2012-6-18 下午02:20:00
 * 
 * @类说明 ：建立一个各种登录方式都适用的接口
 */
public interface Login {
	public boolean verify(String name, String password);
}