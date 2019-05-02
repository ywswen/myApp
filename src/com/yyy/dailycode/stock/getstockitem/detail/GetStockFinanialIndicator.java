package com.yyy.dailycode.stock.getstockitem.detail;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;

/**
 *   @类名： GetStockFinanialIndicator
 *   @描述：获取财务指标
 *   @作者： 杨文胜
 *   @生成时间： 2017年9月6日 上午11:43:33
 *   @修改人：
 *   @修改时间：  
 **/
public class GetStockFinanialIndicator {
	/**
	 * @属性说明：日志
	 **/
	private static final Logger _log = Logger.getLogger(GetStockFinanialIndicator.class);
	/**
	 * @属性说明：url编码
	 **/
	private static final String URL_CODE = "utf-8";
	/**
	 * @属性说明：匹配到的内容
	 **/
	private static final String MATCH_WORDS = "主要指标<span class=";
	/**
	 * @属性说明：正则表达式匹配寻找title    <h3>主要指标<span class="subtit">(2017年中报)</span></h3>
	 * 
	 **/
	private static final String REG_PATTERN = "subtit\">\\((.*?)\\)";
	/**
	 * @属性说明：正则表达式匹配寻找市盈率和市净率   <th>市盈率</th><td id='syl'>47.98 </td> 
	 * 											 <th>市净率</th><td id='sjl'>10.38</td>
	 * 
	 **/
	private static final String REG_PATTERN1 = "l'>(.*?)</td>";
	/**
	 * @属性说明：正则表达式匹配寻找每股收益/每股净资产/营业收入/同比增长/净利润/同比增长/    <td>0.27元</td>以及<td class="comRed">	10.32%        </td>
	 * 
	 **/
	private static final String REG_PATTERN2 = ">(.*?)</td>";
	
//	/**
//	 * @属性说明：正则表达式匹配寻找/同比增长/同比增长/    <td class="comRed">	10.32%        </td>
//	 **/
//	private static final String REG_PATTERN3 = ">(.*?)</td>";
	
	public static void main(String[] args) {
		try {
			String stockCode = "600959";
			String title = "";
			String url = initURLStr(stockCode);
			System.out.println(url);
			updateStockFinacailIndicator(url, stockCode, title, 1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			_log.error("获取基础数据失败！", e);
		}
	}
	
	/**
	 *   @生成时间： 2017年9月8日 下午7:59:26
	 *   @方法说明： 初始化链接地址
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String initURLStr(String stockCode) {
		//http://m.10jqka.com.cn/stockpage/{0}/#&atab=companyInfo
		//http://basic.10jqka.com.cn/mobile/300014/companyn.html
		StringBuffer url = new StringBuffer("http://basic.10jqka.com.cn/mobile/");
		url.append(stockCode);
		url.append("/companyn.html");
//		System.out.println(url.toString());
		return url.toString();
	}
	
	/**
	 *   @生成时间： 2015-12-22 下午05:33:55
	 *   @方法说明： 更新财务指标
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void updateStockFinacailIndicator(String urlStr, String stockCode, String title, int i) {
		URL url = null;
		InputStream is = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			url = new URL(urlStr);
			URLConnection urlcon = url.openConnection();
			urlcon.setConnectTimeout(30000);
			is = urlcon.getInputStream();
			isr = new InputStreamReader(is, URL_CODE);
			br = new BufferedReader(isr);
			@SuppressWarnings("unused")
			int count = 1;
			String line = null;
			Connection conn = null;
			PreparedStatement ps = null;
			// 正则表达式拆分出title,拆分出一个
			Pattern ptitle = Pattern.compile(REG_PATTERN);
			Pattern p1 = Pattern.compile(REG_PATTERN1);
			Pattern p2 = Pattern.compile(REG_PATTERN2);
			String sqlPrefix = new String("update STOCK_ITEMS set PE=?,PB=?,REVENUE=?,NETPROFIT=?,REVENUEROSE=?,NETPROFITROSE=?,EPS=?,NAPS=?,TITLE=?,MODIFY_TIME=? where STOCK_CODE=?");
			try {
//				// 获得链接
				conn = OracleUnit.getConnection();
				ps = conn.prepareStatement(sqlPrefix);
				//获取返回内容，并且返回成功"status":0
				String titleLast=null,pe=null,pb=null,revenue=null,revenuerose=null,netprofit=null,netprofitrose=null,eps=null,naps=null;
				while ((line = br.readLine()) != null ) {
					if (line.contains(MATCH_WORDS)) {
						//line匹配内容为 <h3>主要指标<span class="subtit">(2017年中报)</span></h3>
						Matcher mtitle = ptitle.matcher(line);
						while (mtitle.find()) {
							titleLast = mtitle.group(1);							
						}
						br.readLine();br.readLine();br.readLine();br.readLine();
						//市盈率
						line = br.readLine();
						Matcher m1 = p1.matcher(line);
						while(m1.find()){
							pe = m1.group(1);
						}
						//市净率
						line = br.readLine();
						m1 = p1.matcher(line);
						while(m1.find()){
							pb = m1.group(1);
						}
						//每股收益
						br.readLine();br.readLine();br.readLine();
						line = br.readLine();
						Matcher m2 = p2.matcher(line);
						while(m2.find()){
							eps = m2.group(1);
						}
						//每股净资产
						br.readLine();
						line = br.readLine();
						m2 = p2.matcher(line);
						while(m2.find()){
							naps = m2.group(1);
						}
						//营业收入
						br.readLine();br.readLine();br.readLine();
						line = br.readLine();
						m2 = p2.matcher(line);
						while(m2.find()){
							revenue = m2.group(1).replace("	", "");
						}
						//同比增长
						br.readLine();
						line = br.readLine()+br.readLine();
						m2 = p2.matcher(line);
						while(m2.find()){
							revenuerose = StringUtils.trim(m2.group(1)).replace("	", "");
						}
						//净利润
						br.readLine();br.readLine();br.readLine();
						line = br.readLine();
						m2 = p2.matcher(line);
						while(m2.find()){
							netprofit = m2.group(1).replace("	", "");
						}
						//同比增长
						br.readLine();
						line = br.readLine()+br.readLine();
						m2 = p2.matcher(line);
						while(m2.find()){
							netprofitrose = m2.group(1).replace("	", "");
						}
//						if(titleLast != null && (!titleLast.equals(title))){
							ps.setString(1, pe.trim());
							ps.setString(2, pb);
							ps.setString(3, revenue);
							ps.setString(4, netprofit);
							ps.setString(5, revenuerose);
							ps.setString(6, netprofitrose);
							ps.setString(7, eps);
							ps.setString(8, naps);
							ps.setString(9, titleLast);
							ps.setDate(10, new java.sql.Date(System.currentTimeMillis()));
							ps.setString(11, stockCode);
							ps.executeUpdate();
							conn.commit();
//						}
						break;
					}
					count++;
				}
				
			}catch (Exception e) {
				_log.error("【" + stockCode + "】数据更新数据库数据失败", e);
				conn.rollback();
				throw new Exception(e);
			}
			finally {
				if(ps != null)
					ps.close();
			}
		}catch (FileNotFoundException e) {
			
		} catch (Exception e) {
			_log.error(stockCode + "入库失败！",e);
			i++;
			//为了保证稳定性，请求两次
			if(i<3){
				updateStockFinacailIndicator(urlStr, stockCode, title, i);
			}
		} finally {
			try {
				if (is != null) {
					is.close();
				}
				if (isr != null) {
					isr.close();
				}
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				_log.error("关闭流失败！", e);
			}
		}
	}
	
   
}
