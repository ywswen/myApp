package com.yyy.design.designModel10.proxy.proxytalk;

import junit.framework.TestCase;

/**
 *   @类名： ProxyTest
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-9-21 上午11:25:21
 *   @修改人：
 *   @修改时间：  
 **/
public class ProxyTest extends TestCase{
	public void testTalkAndSing(){
		ITalk yws = new People("Yws",24);
		yws.talk("No Proxy Test");
		TalkProxy tp = new TalkProxy(yws);
		tp.talk("Proxy Test", "Yesterday once more");
	}
}

