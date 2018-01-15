package com.yyy.dailycode.enjoycoding.protocolbuffer.demo;

import com.google.protobuf.InvalidProtocolBufferException;
import com.yyy.dailycode.enjoycoding.protocolbuffer.vo.FinancialDataModel;
import com.yyy.dailycode.enjoycoding.protocolbuffer.vo.StockItemModel;

/**
 *   @类名： ProtocolBufferTest
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2018-1-11 上午11:33:17
 *   @修改人：
 *   @修改时间：  
 **/
public class ProtocolBufferTest {
	/**
	 *   @生成时间： 2018-1-11 下午06:54:39
	 *   @方法说明： 测试main方法
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void main(String[] args) {
		//创建财务数据builder fb,用于放到StockItem si中
		FinancialDataModel.FinancialData.Builder fdb = FinancialDataModel.FinancialData.newBuilder()
		//设置营业收入
		.setRevenue("13.56亿")
		//设置营业收入增长率
		.setRevenuerose("29.56%")
		//设置净利润
		.setNetprofit("2.98亿")
		//设置净利润增长率
		.setNetprofitrose("21.37%");
		
		//创建日k线数据builder sdb,用于放到StockItem si中
		StockItemModel.StockItem.StockData.Builder sdb = StockItemModel.StockItem.StockData.newBuilder()
		//设置股票编码
		.setStockCode("300463")
		//设置开盘价
		.setOpen("22.12")
		//设置收盘价
		.setClose("22.22")
		//设置股票名称
		.setHigh("22.45")
		//设置股票财务数据
		.setLow("22.12")
		//设置市盈率
		.setPe("31.18")
		//设置股票日K线数据日期
		.setDatestr("2018-01-11");
		
		StockItemModel.StockItem si = StockItemModel.StockItem.newBuilder()
		//设置股票id
		.setStockId("sz300463")
		//设置股票编码
		.setStockCode("300463")
		//设置股票名称
		.setStockName("迈克生物")
		//设置股票财务数据
		.setFinancialData(fdb)
		//设置股票日k线数据
		.setStockData(sdb)
		.build();
		//打印股票信息
		System.out.println(si.toString());
		
		//反向解析股票信息
        try {
        	byte[] array = si.toByteArray();
        	StockItemModel.StockItem si2 = StockItemModel.StockItem.parseFrom(array);
            System.out.println(si2.toString());
            //在这里打印股票名称
            System.out.println(si2.getStockName().toString());
        } catch (InvalidProtocolBufferException e) {
            e.printStackTrace();
        }
	}
}
