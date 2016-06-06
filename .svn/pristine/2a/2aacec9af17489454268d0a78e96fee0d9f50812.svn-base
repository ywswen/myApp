package com.yyy.dailycode.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.log4j.Logger;

import com.yyy.dailycode.db.dbunit.OracleUnit;
import com.yyy.dailycode.exception.loadproperties.LoadErrorProperties;
import com.yyy.dailycode.stock.vo.StockData;
import com.yyy.dailycode.stock.vo.StockItems;

/**
 * @类名： GetStockHisData
 * @描述： 导入历史数据
 * @作者： 杨文胜
 * @生成时间： 2015-12-22 下午05:47:43
 * @修改人：
 * @修改时间：
 **/
public class GetStockHisData {
    /**
     * @属性说明：日志
     **/
    private static final Logger _log = Logger.getLogger(GetStockHisData.class);

    /**
     * @属性说明：批量导入的记录数
     **/
    private static final int BATCH = 50;

    /**
     * @属性说明：执行的插入sql
     **/
    private static final String SQL_PREFIX = "insert into stock_data(stock_code,date1,open,high,low,close,volume) values(?,?,?,?,?,?,?)";

    /**
     * @属性说明：json数据来源的url地址
     **/
    private static final String URL = "http://gupiao.baidu.com/api/stocks/stockdaybar?from=pc&os_ver=1&cuid=xxx&vv=100&format=json&stock_code={0}&step=3&start=&count=10&fq_type=no";

    public static void main(String[] args) throws Exception {
	loadDataOneConnection();
    }

    /**
     * @生成时间： 2015-12-22 下午05:12:02
     * @方法说明： stockCode代码，cycleType周期类型，日：d、月:m、年:y
     * @参数：
     * @返回值：
     * @异常：
     **/
    public static String initURLStr(String stockCode, String cycleType) {
	Object[] params = new Object[] { stockCode };
	return MessageFormat.format(URL, params);
    }

    /**
     * @生成时间： 2015-12-29 上午10:34:31
     * @方法说明： 一个股票代码一个连接
     * @参数：
     * @返回值：
     * @throws Exception
     * @异常：
     **/
    public static void loadDataOneStockOneConnction() throws SQLException {
	List<StockItems> listStockItems = new GetStockDataFromDB()
		.getStockItems();
	String stockId, stockCode, initURLStr;
	for (StockItems si : listStockItems) {
	    // stockId = "sz002741";
	    // stockCode = "sz002741";
	    stockId = si.getStock_id();
	    stockCode = si.getStock_code();
	    initURLStr = initURLStr(stockId, CYCLETYPE);
	    loadDataToDb(initURLStr, stockCode);
	}
    }

    /**
     * @生成时间： 2015-12-29 上午10:33:40
     * @方法说明： 一个数据库连接入库所有的数据
     * @参数：
     * @返回值：
     * @异常：throws SQLException
     **/
    public static void loadDataOneConnection() throws SQLException {
	Connection conn = null;
	PreparedStatement ps = null;
	try {
	    List<StockItems> listStockItems = new GetStockDataFromDB()
		    .getStockItems();
	    // 获得链接
	    conn = OracleUnit.getConnection();
	    ps = conn.prepareStatement(SQL_PREFIX);
	    String stockId, stockCode, initURLStr;
	    // stockId = "sz002741";
	    // stockCode = "sz002741";
	    // initURLStr = initURLStr(stockId, CYCLETYPE);
	    // loadDataFromBaiduToDbOneCon(initURLStr, stockCode, conn, ps,
	    // sqlPrefix);
	    for (StockItems si : listStockItems) {
		stockId = si.getStock_id();
		stockCode = si.getStock_code();
		initURLStr = initURLStr(stockId, CYCLETYPE);
		loadDataFromBaiduToDbOneCon(initURLStr, stockCode, conn, ps,
			SQL_PREFIX);
	    }
	} catch (Exception e) {
	    _log.error(LoadErrorProperties.getValue(ERROR_001), e);
	} finally {
	    if (ps != null) {
		ps.close();
	    }
	    if (conn != null) {
		conn.close();
	    }
	}
    }

    /**
     * @生成时间： 2015-12-22 下午05:33:55
     * @方法说明： 从百度获取获取数据入库,使用一个数据库连接，数据库异常直接跳出，不再执行，网络连接异常继续跑下一个股票代码
     * @参数：
     * @返回值：
     * @异常：throws SQLException
     **/
    @SuppressWarnings("unchecked")
    public static void loadDataFromBaiduToDbOneCon(String urlStr,
	    String stockCode, Connection conn, PreparedStatement ps,
	    String sqlPrefix) throws SQLException {
	URL url = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	try {
	    url = new URL(urlStr);
	    URLConnection urlcon = url.openConnection();
	    urlcon.setConnectTimeout(30000);
	    is = urlcon.getInputStream();
	    isr = new InputStreamReader(is);
	    br = new BufferedReader(isr);
	    int count = 0;
	    String jsonStr = null;
	    try {
		while ((jsonStr = br.readLine()) != null) {
		    JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		    JSONArray jsonArray = jsonObject.getJSONArray(MASHDATA);
		    Collection<StockData> col = JSONArray.toCollection(
			    jsonArray, StockData.class);
		    Iterator<StockData> it = col.iterator();
		    while (it.hasNext()) {
			StockData sd = it.next();
			String date = sd.getDate();
			Map<String, Object> kline = sd.getKline();
			if (count % BATCH == 0 && count != 0) {
			    ps.executeBatch();
			    ps.close();
			    ps = conn.prepareStatement(sqlPrefix);
			}
			ps.setString(1, stockCode);
			ps.setString(2, date);
			ps.setString(3, kline.get(OPEN).toString());
			ps.setString(4, kline.get(HIGH).toString());
			ps.setString(5, kline.get(LOW).toString());
			ps.setString(6, kline.get(CLOSE).toString());
			ps.setString(7, kline.get(VOLUME).toString());
			ps.addBatch();
		    }
		    count++;
		}
		ps.executeBatch();
		conn.commit();
		_log.debug("股票号【" + stockCode + "】，入库成功！");
	    } catch (IOException e) {
		_log.error(LoadErrorProperties.getValue(ERROR_002,
			new Object[] { stockCode, count }), e);
	    } catch (SQLException e) {
		_log.error(LoadErrorProperties.getValue(ERROR_003,
			new Object[] { stockCode, count }), e);
		conn.rollback();
	    }
	} catch (IOException e) {
	    _log.error(LoadErrorProperties.getValue(ERROR_004, new Object[] {
		    stockCode, urlStr }), e);
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
		_log.error(LoadErrorProperties.getValue(ERROR_005,
			new Object[] { stockCode, urlStr }), e);
	    }
	}
    }

    /**
     * @生成时间： 2015-12-22 下午05:33:55
     * @方法说明： 根据url和股票代码入库，每个url一个连接
     * @参数：
     * @返回值：
     * @异常：throws SQLException
     **/
    @SuppressWarnings("unchecked")
    public static void loadDataToDb(String urlStr, String stockCode)
	    throws SQLException {
	URL url = null;
	InputStream is = null;
	InputStreamReader isr = null;
	BufferedReader br = null;
	try {
	    url = new URL(urlStr);
	    URLConnection urlcon = url.openConnection();
	    urlcon.setConnectTimeout(30000);
	    is = urlcon.getInputStream();
	    isr = new InputStreamReader(is);
	    br = new BufferedReader(isr);
	    int count = 0;
	    String jsonStr = null;
	    Connection conn = null;
	    PreparedStatement ps = null;
	    try {
		// // 获得链接
		conn = OracleUnit.getConnection();
		ps = conn.prepareStatement(SQL_PREFIX);
		while ((jsonStr = br.readLine()) != null) {
		    JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		    JSONArray jsonArray = jsonObject.getJSONArray(MASHDATA);
		    Collection<StockData> col = JSONArray.toCollection(
			    jsonArray, StockData.class);
		    Iterator<StockData> it = col.iterator();
		    while (it.hasNext()) {
			StockData sd = it.next();
			String date = sd.getDate();
			Map<String, Object> kline = sd.getKline();
			if (count % BATCH == 0 && count != 0) {
			    ps.executeBatch();
			    ps.close();
			    ps = conn.prepareStatement(SQL_PREFIX);
			}
			ps.setString(1, stockCode);
			ps.setString(2, date);
			ps.setString(3, kline.get(OPEN).toString());
			ps.setString(4, kline.get(HIGH).toString());
			ps.setString(5, kline.get(LOW).toString());
			ps.setString(6, kline.get(CLOSE).toString());
			ps.setString(7, kline.get(VOLUME).toString());
			ps.addBatch();
		    }
		    count++;
		}
		ps.executeBatch();
		conn.commit();
		_log.debug("股票号【" + stockCode + "】，入库成功！");
	    } catch (IOException e) {
		_log.error(LoadErrorProperties.getValue(ERROR_002,
			new Object[] { stockCode, count }), e);
	    } catch (SQLException e) {
		_log.error(LoadErrorProperties.getValue(ERROR_003,
			new Object[] { stockCode, count }), e);
		conn.rollback();
	    } finally {
		if (ps != null)
		    ps.close();
	    }
	} catch (IOException e) {
	    _log.error(LoadErrorProperties.getValue(ERROR_004, new Object[] {
		    stockCode, urlStr }), e);
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
		_log.error(LoadErrorProperties.getValue(ERROR_005,
			new Object[] { stockCode, urlStr }), e);
	    }
	}
    }

    /**
     * @属性说明：周期类型，日：d、月:m、年:y
     **/
    private static final String CYCLETYPE = "d";

    /**
     * @属性说明：json数据格式中的股票数据title
     **/
    private static final String MASHDATA = "mashData";

    /**
     * @属性说明：股票的开盘价
     **/
    private static final String OPEN = "open";

    /**
     * @属性说明：股票的最高点
     **/
    private static final String HIGH = "high";

    /**
     * @属性说明：股票的收盘价
     **/
    private static final String CLOSE = "close";

    /**
     * @属性说明：股票的最低点
     **/
    private static final String LOW = "low";

    /**
     * @属性说明：股票的成交量
     **/
    private static final String VOLUME = "volume";

    /**
     * @属性说明：错误代码001
     **/
    private static final String ERROR_001 = "error_001";

    /**
     * @属性说明：错误代码002
     **/
    private static final String ERROR_002 = "error_002";

    /**
     * @属性说明：错误代码003
     **/
    private static final String ERROR_003 = "error_003";

    /**
     * @属性说明：错误代码004
     **/
    private static final String ERROR_004 = "error_004";

    /**
     * @属性说明：错误代码005
     **/
    private static final String ERROR_005 = "error_005";
}
