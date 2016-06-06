package com.yyy.dailycode.enjoycoding.getpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.URIException;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.httpclient.util.URIUtil;
import org.apache.log4j.Logger;

/**
 *   @类名： HttpTookitEnhance
 *   @描述： httpclient模拟http请求，解决返回内容乱码问题
 *   @作者： 杨文胜
 *   @生成时间： 2016-6-3 下午05:52:48
 *   @修改人：
 *   @修改时间：  
 **/
public class HttpTookitEnhance {
	/**
	 * @属性说明：日志
	 **/
	private static final Logger log = Logger.getLogger(HttpTookitEnhance.class);
	/**
	 * @属性说明：文件换行符
	 **/
	private static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	/**
	 * 执行一个HTTP GET请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param queryString
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doGet(String url, String queryString, String charset, boolean pretty) {
		StringBuffer response = new StringBuffer();
		HttpClient client = new HttpClient();
		GetMethod method = new GetMethod(url);
		try {
			if (queryString != null && !queryString.equals(""))
				// 对get请求参数做了http请求默认编码，好像没有任何问题，汉字编码后，就成为%式样的字符串
				method.setQueryString(URIUtil.encodeQuery(queryString));
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
				String line;
				while ((line = reader.readLine()) != null) {
					if (pretty)
						response.append(line).append(LINE_SEPARATOR);
					else
						response.append(line);
				}
				reader.close();
			}
		} catch (URIException e) {
			log.error("请检查url地址是否正确！", e);
		} catch (IOException e) {
			log.error("IO异常", e);
		} finally {
			method.releaseConnection();
		}
		return response.toString();
	}

	/**
	 * 执行一个HTTP POST请求，返回请求响应的HTML
	 * 
	 * @param url
	 *            请求的URL地址
	 * @param params
	 *            请求的查询参数,可以为null
	 * @param charset
	 *            字符集
	 * @param pretty
	 *            是否美化
	 * @return 返回请求响应的HTML
	 */
	public static String doPost(String url, Map<String, String> params, String charset, boolean pretty) {
		StringBuffer response = new StringBuffer();
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(url);
		// 设置Http Post数据
		if (params != null) {
			HttpMethodParams p = new HttpMethodParams();
			for (Map.Entry<String, String> entry : params.entrySet()) {
				p.setParameter(entry.getKey(), entry.getValue());
			}
			method.setParams(p);
		}
		try {
			client.executeMethod(method);
			if (method.getStatusCode() == HttpStatus.SC_OK) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(method.getResponseBodyAsStream(), charset));
				String line;
				while ((line = reader.readLine()) != null) {
					if (pretty)
						response.append(line).append(System.getProperty("line.separator"));
					else
						response.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			log.error("IO异常", e);
		} finally {
			method.releaseConnection();
		}
		return response.toString();
	}
	class TestGetPost{
		
	}
	public static void main(String[] args) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "yangwensheng");
		params.put("password", "www.8.com");
		params.put("pwd", "www.8.com");
		//username=yangwensheng&password=www.8.com&pwd=www.8.com&secret=true
		params.put("secret", "true");
//		String y = doGet("http://video.sina.com.cn/life/tips.html", null, "GBK", true);
		//String post = doPost("http://192.168.100.1/webAuth/", params, "GBK", true);
		String get = doGet("http://192.168.100.1/webAuth/", "username=yangwensheng&password=www.8.com&pwd=www.8.com&secret=true", "utf-8", false);
		System.out.println(get);
		//System.out.println(post);
	}

}
