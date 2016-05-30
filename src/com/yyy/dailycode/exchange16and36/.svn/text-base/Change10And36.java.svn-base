package com.yyy.dailycode.exchange16and36;
/**
 *   @类名： Change
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-6-22 下午01:30:39
 *   @修改人：
 *   @修改时间：  
 **/
public class Change10And36 {
	//将数字转换为自定义36进制
	public static String setIntegerToSequence(Integer i){
		String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int a = i/36;
		int b = i%36;
		return s.substring(a, a+1) + s.substring(b, b+1);
//		return i<10 ? "0"+(i) : ""+(i);
	}
	
	//将自定义36进制转换为十进制
	public static int getSequenceToInteger(String tuxlx){
//		String s = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//		int a = s.indexOf(tuxlx.substring(0, 1));
//		int b = s.indexOf(tuxlx.substring(1));
//		int i = 16*a + b;
//		return i;
		return Integer.parseInt(tuxlx)-1;
	}
}

