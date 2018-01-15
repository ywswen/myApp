package com.yyy.dailycode.stock.getstockitem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.yyy.dailycode.stock.vo.StockItems;

/**
 *   @类名： TestPrintUrlContent
 *   @描述： 测试打印网页内容
 *   @作者： 杨文胜
 *   @生成时间： 2017-5-1 下午05:48:46
 *   @修改人：
 *   @修改时间：  
 **/
public class TestPrintUrlContent {
	/**
	 * @属性说明：获取编号和名称的url
	 **/
	private static final String STOCK_URL = "http://money.finance.sina.com.cn/corp/go.php/vMS_MarketHistory/stockid/600000.phtml";
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(TestPrintUrlContent.class);
	/**
	 * @属性说明：url编码
	 **/
//	@SuppressWarnings("unused")
//	private static final String URL_CODE = "gbk";
	/**
	 * @属性说明：正则表达式匹配寻找id/code/name
	 **/
	private static final String REG_PATTERN = "<a target='_blank's+href='http://biz.finance.sina.com.cn/stock/history_min.php?symbol=shd{6}&date=d{4}-d{2}-d{2}'>s*([^s]+)s+</a>s*</div></td>s*<td[^d]*([^<]*)</div></td>s+<td[^d]*([^<]*)</div></td>s+<td[^d]*([^<]*)</div></td>s+<td[^d]*([^<]*)</div></td>s+";
	/**
	 * @属性说明：匹配到的内容
	 **/
	private static final String MATCH_WORDS = "http://quote.eastmoney.com/";
	/**
	 * @属性说明：点号
	 **/
	private static final String DOT = ".";
	
	public static void main(String[] args) {
		try {
			initDataToDataBase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    public static void initDataToDataBase() throws SQLException{
			getAllStackCodes();
    }  
    /**
     *   @生成时间： 2017-4-28 下午02:54:47
     *   @方法说明： 获取所有的初始化数据
     *   @参数：
     *   @返回值： 
     *   @异常：
     **/
    private static List<StockItems> getAllStackCodes() {
		URL url = null;
		String line = null;
		InputStream is = null;
		BufferedReader br = null;
		InputStreamReader isr = null;
		URLConnection connection = null;
		// 正则表达式拆分出Id,Code,Name,拆分出三个
		Pattern p = Pattern.compile(REG_PATTERN);
		List<StockItems> listStockItems = new ArrayList<StockItems>();
		try {
			String stockId;
			url = new URL(STOCK_URL);
			connection = url.openConnection();
			connection.setConnectTimeout(30000);
			is = connection.getInputStream();
			isr = new InputStreamReader(is,"gbk");
			br = new BufferedReader(isr);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
				if (line.contains(MATCH_WORDS)) {
					//line匹配内容为 <li><a target="_blank" href="http://quote.eastmoney.com/sz300651.html">金陵体育(300651)</a></li>
					Matcher m = p.matcher(line);
					while (m.find()) {
						StockItems si = new StockItems();
						stockId = m.group(1);
						si.setStock_id(stockId);
						si.setStock_name(m.group(2));
						si.setStock_code(m.group(3));
						si.setStock_code_url(stockId.substring(2) + DOT + stockId.substring(0, 2));
						listStockItems.add(si);
					}
				}
			}
		} catch (Exception e) {
			_log.error("获取日志失败", e);
		}finally{
				try {
					if(is != null)
						is.close();
					if(br != null)
						br.close();
					if(isr != null)
						isr.close();
				} catch (IOException e) {
					_log.error("关闭网络连接失败！", e);
				}
		}
		return listStockItems;
	}  
}
