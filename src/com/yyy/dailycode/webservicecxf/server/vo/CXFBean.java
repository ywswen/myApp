package com.yyy.dailycode.webservicecxf.server.vo;

import java.util.Map;

/**
 *  @类名： CXFBean
 *  @描述： 
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-13 上午10:16:47
 *  @修改人：
 *  @修改时间：
 */
public class CXFBean {
	/**
	 * @属性说明：名称
	 **/
	private String name;
	/**
	 * @属性说明：描述
	 **/
	private String des;
	/**
	 * @属性说明：map集合
	 **/
	private Map<String, Object> map;
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
}

