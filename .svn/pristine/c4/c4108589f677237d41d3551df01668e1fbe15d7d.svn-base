package com.yyy.dailycode.wyp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author win young
 *
 * @创建时间:2012-7-25 下午05:37:44
 *
 * @version 1
 *
 * @类说明：
 */

@SuppressWarnings("hiding")
public class Pair<String, BlogReturnStatus> {
	public String name;
	@SuppressWarnings("unused")
	private BlogReturnStatus status;
	public Pair(String name, BlogReturnStatus status) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.status = status;
		System.out.println(name);
	}
	@SuppressWarnings("unchecked")
	public String getSecond() {
		// TODO Auto-generated method stub
		Date date = new Date();
		SimpleDateFormat sf = new SimpleDateFormat("yyyyMMdd hhssmm");
		String second = (String)sf.format(date);
		return second;
	}
}
