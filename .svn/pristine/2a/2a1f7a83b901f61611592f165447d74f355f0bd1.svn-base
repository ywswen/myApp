package com.yyy.dailycode.stock.getstockitem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.log4j.Logger;

import com.yyy.dailycode.stock.getstockdata.diffchannel.GetStockDataFromDB;
import com.yyy.dailycode.stock.getstockitem.detail.GetStockFinanialIndicator;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 *   @类名： MulthreadImport
 *   @描述： 多线程更新财务指标数据
 *   @作者： 杨文胜
 *   @生成时间： 2017-4-25 下午02:15:00
 *   @修改人：
 *   @修改时间：  
 **/
public class MulthreadFinanialIndicatorImport{
	private static final Logger log = Logger.getLogger(MulthreadFinanialIndicatorImport.class);
	LinkedList<StockItems> listStockItems = new GetStockDataFromDB().getStockItems();

//	public void dealListWithMutiThread() {
//		StockItems si = null;
//		String stockCode, initURLStr, title;
//		log.info("start");
//		for (int i = 0; i < listStockItems.size(); i++) {
//			si = listStockItems.get(i);
//			// 通过同花顺获取数据
//			stockCode = si.getStock_code();
//			title = si.getTitle();
//			initURLStr = GetStockFinanialIndicator.initURLStr(stockCode);
//			GetStockFinanialIndicator.updateStockFinacailIndicator(initURLStr, stockCode, title, 1);
//		}
//		// 返回处理结果
//		log.info("end");
//
//	}
	public void dealListWithMutiThread() {
		List<StockItems> list = listStockItems;
		int index = 0;
		ExecutorService ex = Executors.newFixedThreadPool(500);
		int dealSize = 100;
		List<Future<List<StockItems>>> futures = new ArrayList<Future<List<StockItems>>>(500);
		// 分配
		for (int i = 0; i < 500; i++, index += dealSize) {
			int start = index;
			if (start >= list.size())
				break;
			int end = start + dealSize;
			end = end > list.size() ? list.size() : end;
			futures.add(ex.submit(new Task(list, start, end)));
		}
		try {
			// 处理
			List<StockItems> result = new ArrayList<StockItems>();
			for (Future<List<StockItems>> future : futures) {
				// 合并操作
				result.addAll(future.get());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("123");
		ex.shutdown();
	}

	private class Task implements Callable<List<StockItems>> {

		private List<StockItems> list;
		private int start;
		private int end;

		public Task(List<StockItems> list, int start, int end) {
			this.list = list;
			this.start = start;
			this.end = end;
		}
		public List<StockItems> call() throws Exception {
			StockItems si = null;
            List<StockItems> retList = new ArrayList<StockItems>();
			String stockCode, initURLStr, title;
            for(int i=start;i<end;i++){
                si = list.get(i);
//              通过同花顺获取数据
                stockCode = si.getStock_code();
                title = si.getTitle();
                initURLStr = GetStockFinanialIndicator.initURLStr(stockCode);
                GetStockFinanialIndicator.updateStockFinacailIndicator(initURLStr, stockCode, title, 1);;
//                System.out.println();
            }
            //返回处理结果
            return retList;
        }

	}


	public static void main(String[] args) {
		MulthreadFinanialIndicatorImport m = new MulthreadFinanialIndicatorImport();
		m.dealListWithMutiThread();
	}
}
