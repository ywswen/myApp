package com.yyy.dailycode.stock.vo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StockData {
	private String date;
	private Map<String, Object> kline;
	private Map<String, Object> ma5;
	private Map<String, Object> ma10;
	private Map<String, Object> ma20;
	private Map<String, Object> macd;
	private Map<String, Object> kdj;
	private Map<String, Object> rsi;
	private List<StockEvent> event = new ArrayList<StockEvent>();
	public List<StockEvent> getEvent() {
		return event;
	}
	public void setEvent(List<StockEvent> event) {
		this.event = event;
	}
	public Map<String, Object> getMa20() {
		return ma20;
	}
	public void setMa20(Map<String, Object> ma20) {
		this.ma20 = ma20;
	}
	public Map<String, Object> getMacd() {
		return macd;
	}
	public void setMacd(Map<String, Object> macd) {
		this.macd = macd;
	}
	public Map<String, Object> getKdj() {
		return kdj;
	}
	public void setKdj(Map<String, Object> kdj) {
		this.kdj = kdj;
	}
	public Map<String, Object> getRsi() {
		return rsi;
	}
	public void setRsi(Map<String, Object> rsi) {
		this.rsi = rsi;
	}
	public Map<String, Object> getMa5() {
		return ma5;
	}
	public void setMa5(Map<String, Object> ma5) {
		this.ma5 = ma5;
	}
	public Map<String, Object> getMa10() {
		return ma10;
	}
	public void setMa10(Map<String, Object> ma10) {
		this.ma10 = ma10;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Map<String, Object> getKline() {
		return kline;
	}
	public void setKline(Map<String, Object> kline) {
		this.kline = kline;
	}
}
