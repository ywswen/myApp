package com.yyy.design.designModel10.proxy.proxytalk;
/**
 *   @类名： TalkProxy
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-9-21 上午11:19:32
 *   @修改人：
 *   @修改时间：  
 **/
public class TalkProxy {
	private ITalk talker;
	public TalkProxy(ITalk talker) {
		this.talker = talker;
	}
	public void talk(String msg){
		talker.talk(msg);
	}
	public void sing(String song){
		System.out.println("唱《" + song + "》歌");
	}
	public void talk(String msg, String song){
		talk(msg);
		sing(song);
	}
}

