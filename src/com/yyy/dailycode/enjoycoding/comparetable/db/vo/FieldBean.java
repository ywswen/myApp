package com.yyy.dailycode.enjoycoding.comparetable.db.vo;

public class FieldBean {
	private String tablename;
	/**
	 * @属性说明：列名称
	 **/
	private String colname;
	/**
	 * @属性说明：列描述
	 **/
	private String colcomment;
	/**
	 * @属性说明：是否为空
	 **/
	private String nullable;
	/**
	 * @属性说明：字段类型（包含长度）
	 **/
	private String zd_zdlx;
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getColname() {
		return colname;
	}
	public void setColname(String colname) {
		this.colname = colname;
	}
	public String getColcomment() {
		return colcomment;
	}
	public void setColcomment(String colcomment) {
		this.colcomment = colcomment;
	}
	public String getZd_zdlx() {
		return zd_zdlx;
	}
	public void setZd_zdlx(String zd_zdlx) {
		this.zd_zdlx = zd_zdlx;
	}
	public String getNullable() {
		return nullable;
	}
	public void setNullable(String nullable) {
		this.nullable = nullable;
	}
	
}
