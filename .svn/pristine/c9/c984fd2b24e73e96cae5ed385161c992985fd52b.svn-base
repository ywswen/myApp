package com.test;
/*
 * @#DataForamtter.java	
 * Created on 2011-4-22 下午02:42:53
 * Copyright 2011 SINODATA All rights reserved.
 */


import java.io.File;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.tree.DefaultAttribute;


/**
 * 数据格式化工具
 * @since 1.5
 * @author LiuYu
 * @version 1.01, 2011-4-22
 */
public class DataFormatter {

	private static Logger _log = Logger.getLogger(DataFormatter.class);

	public static final String DECIMAL_FORMAT = "#,##0.00";

	/**
	 * @描述        支付密码结果返回代码对应中文描述
	 */
	public enum ERRINFO
	{
		日期非法,付方帐号非法,支付密码校验时收方帐号非法,票据种类非法,票据号码非法,
		金额非法,支付密码非法,数据库操作失败,操作指令非法,支付密码校验卡操作失败,
		数据库中信息错误,无此机具号,库中无此密码器帐号,支付密码正确机具已停用,
		支付密码正确机具已作废,机具已注销,支付密码正确机具状态非法,
		支付密码正确账号已删除或密钥更改,支付密码错误,支付密码正确,未知错误
	};
	
	//16进制的数值
    static final String[] HEX = {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
    
    static String hex = "";
	
	public static String formatMoney(String moneyStr) {
		try {
			double money = 0;
			if (moneyStr == null
					|| moneyStr.trim().equals("")) {
				money = 0;
			} else if (moneyStr.indexOf(".") >= 0) {// 带小数点，以元为单位
				money = Double.parseDouble(moneyStr);
			} else {
				money = Double.parseDouble(moneyStr) / 100;
			}
			DecimalFormat df = new DecimalFormat("#,##0.00");
			moneyStr = df.format(money);
			return moneyStr;
		} catch (Exception ex) {
			_log.error("", ex);
			return "0.00";
		}
	}

	/**
	 * 根据传入格式返回当前日期
	 * 
	 * @param formatStr
	 *            a <code>String</code> defines the date form ,such as
	 *            "yyyyMMdd"
	 * @return currentDate
	 * 
	 * @exception RuntimeException
	 */
	public static String getCurrentDate(String formatStr) throws RuntimeException {
		SimpleDateFormat format = new SimpleDateFormat(formatStr);
		// 当前日期
		Date currentDate = new Date();
		return format.format(currentDate);
	}
	
	/**
	 * 将报文中的循环体取出
	 * 
	 * @param vo
	 * @return List<Map<String, String>>
	 * @exception Exception
	 */
	public static List<Map<String, String>> getListFromVO(Map<String, String> vo) throws Exception {
		Set<String> ss = vo.keySet();
		int h = 0;
		for (String s : ss) {
			if (s.matches("[A-Z]+\\.+[0-9]+")) {
				int index = Integer.parseInt(s.substring(s.indexOf(".") + 1));
				if (index > h) {
					h = index;
				}
			}
		}
		if (h != 0) {
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			for (int i = 0; i < h; i++) {
				Map<String, String> map = new HashMap<String, String>();
				for (String key : ss) {
					String[] k = key.split("\\.");
					if (k.length == 2
							&& k[1].equals(String.valueOf(i + 1))) {
						map.put(k[0], vo.get(key));
					}
				}
				list.add(map);
			}
			return list;
		}
		return null;
	}

	/**
	 * 字符串填充方法

	 * 
	 * @param src
	 *            The source string
	 * @param length
	 *            Length of the specific string
	 * @param filling
	 *            Which fill forward or backward the string if the length of
	 *            original string is not enough
	 * @param direction
	 *            <i>F</i> -- forward ; <i>B</i> -- backward
	 * 
	 * @return theSpecificString
	 */
	public static String getSpecificString(String src,int length,byte filling,String direction) {
		StringBuffer retStr = new StringBuffer();
		try {
			//byte[] bytes = src.getBytes();
			int len = src.length();
//			if (len > length) {
////				byte rbyte[] = new byte[length];
////				memcpy(rbyte, bytes);
////				retStr = new StringBuffer(new String(rbyte));
//				retStr.append(src);
//			} else {
			if (direction.equals("F")) {
				for (int i = 0; i < (length - len); i++) {
					retStr.append((char)filling);
				}
				retStr.append(src);
			} else if (direction.equals("B")) {
				retStr.append(src);
				for (int i = 0; i < (length - len); i++) {
					retStr.append((char)filling);
				}
			}
//			}
		} catch (Exception e) {
			_log.error("charactersFilling exception ", e);
			return null;
		}
		return retStr.toString();
	}

	/**
	 * 读取XML文件
	 * 
	 * @param fileName
	 *            带路径的文件名

	 * @return 文件内容(字符串)
	 */
	public static String getStringFromFile(String fileName) {
		FileInputStream fis = null;
		File file = new File(fileName);
		byte[] read = new byte[0];
		try {
			fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len = 0;
			int count = 0;
			_log.debug("Processing File : "
					+ file.getName());
			while ((len = fis.read(buffer)) != -1) {
				byte[] btemp = new byte[len];
				memcpy(btemp, buffer);
				read = memmerge(read, btemp);
				count += len;
			}
			_log.debug("Finish Processing "
					+ file.getName()
					+ ", "
					+ count
					+ " Bytes Have Read.");
		} catch (FileNotFoundException e) {
			_log.error(" getStringFromFile ", e);
			e.printStackTrace();
		} catch (IOException e) {
			_log.error(" getStringFromFile ", e);
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				_log.error(" getStringFromFile ", e);
			}
			fis = null;
		}
		return new String(read);
	}
	
	/**
	 * 
	 * 方法描述 修改日志
	 * 
	 * @param
	 * @return
	 * @exception
	 */
	public static void memcpy(byte[] dest,byte[] src) {
		System.arraycopy(src, 0, dest, 0, dest.length);
	}

	/**
	 * 
	 * 方法描述 修改日志
	 * 
	 * @param
	 * @return
	 * @exception
	 */
	public static byte[] memmerge(byte[] src,byte[] merge) {
		int slen = src.length;
		int mlen = merge.length;
		byte[] r = new byte[slen
				+ mlen];
		System.arraycopy(src, 0, r, 0, slen);
		System.arraycopy(merge, 0, r, slen, mlen);
		return r;
	}

	/**
	 * 将Map转化为json字符串

	 * 
	 * @param map
	 * @return jsonString
	 */
	public static String parseMap2JsonString(Map<String, String> map) {
		StringBuffer json = new StringBuffer("{");
		try {
			Set<String> keys = map.keySet();
			for (String key : keys) {
				json.append("\"");
				json.append(key);
				json.append("\":\"");
				json.append(map.get(key));
				json.append("\",");
			}
			json.delete(json.length() - 1, json.length());
			json.append("}");
		} catch (Exception e) {
			_log.error("JSON转化错误：", e);
			return null;
		}
		return json.toString();
	}

	/**
	 * 将VO转化为json字符串
	 * @param vo
	 * @return jsonString
	 */
	public static String parseVO2JsonString(Map<String, String> vo) {
		StringBuffer json = new StringBuffer("{");
		try {
			Set<String> keys = vo.keySet();
			for (String key : keys) {
				json.append("\"");
				json.append(key);
				json.append("\":\"");
				json.append(vo.get(key));
				json.append("\",");
			}
			json.delete(json.length() - 1, json.length());
			json.append("}");
		} catch (Exception e) {
			_log.error("JSON转化错误：", e);
			return null;
		}
		return json.toString();
	}

	/**
	 * 解析XML字符串(循环类型)
	 * 
	 * 
	 * 
	 * @param xmlStr
	 *            XML字符串

	 * @param xpath
	 *            XPath路径
	 * @return VOList
	 */
	@SuppressWarnings("unchecked")
	public static List<Map<String, String>> parseXML2List(String xmlStr,String xpath) {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		Document document = null;
		try {
			_log.debug("Start Parsing XML 2 List... ...");
			document = DocumentHelper.parseText(xmlStr);
			List nodeList = document.selectNodes(xpath);
			int listLen = nodeList.size();
			for (int i = 0; i < listLen; i++) {
				_log.debug("No."
						+ i
						+ " Node processing...");
				Map<String, String> elevo = new HashMap<String, String>();
				org.dom4j.Element ele = (org.dom4j.Element) nodeList.get(i);
				_log.debug(ele.attributeCount()
						+ " attributes");
				List<DefaultAttribute> attrs = ele.attributes();
				for (DefaultAttribute attr : attrs) {
					elevo.put("a_"
							+ attr.getName(), attr.getValue());
					_log.debug("add attribute ["
							+ attr.getName()
							+ "] value:"
							+ attr.getValue());
				}
				List l = ele.selectNodes("*");
				for (int j = 0; j < l.size(); j++) {
					org.dom4j.Element e = (org.dom4j.Element) l.get(j);
					String keyName = e.attributeValue("name") == null ? e.getName() : e.attributeValue("name");
					String value = e.getText().trim();
					if (value == null
							|| value.equals("")) {
						List<org.dom4j.Element> subList = e.selectNodes("*");
						for (org.dom4j.Element ee : subList) {
							if (ee.getName().equalsIgnoreCase("name")
									|| ee.getName().equalsIgnoreCase("value")) {
								value = ee.getText();
								break;
							}
						}
					}
					elevo.put(keyName, value);
					_log.debug("add param ["
							+ keyName
							+ "] value:"
							+ value);
				}
				list.add(elevo);
			}
			_log.debug(listLen
					+ " Objects Parsed.");
		} catch (Exception e) {
			_log.error("", e);
		}
		return list;
	}
	
	/**
     * byteHEX()
     */
    public static String byteHEX(byte ib)
    {
        char[] Digit = {
            '0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib>>>4)&0X0F];
        ob[1] = Digit[ib&0X0F];
        String s = new String(ob);
        return s;
    }
    /**
     * @描述 accis     
     * @param ib
     * @return
     */
    public static String intToChar(int ib){
    	char ch = (char)ib;
    	String s = ch + "";
    	return s;
    }
    
    /**
     * @描述  十六进制码
     */
    /**
     * byteHEX()
     */
    public static String intToHex(byte ib){
        char[] Digit = {
            '0','1','2','3','4','5','6','7','8','9',
            'A','B','C','D','E','F'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib>>>4)&0X0F];
        ob[1] = Digit[ib&0X0F];
        String s = new String(ob);
        return s;
    }
    /**
     * 字符串转换为ASCII码
     * @描述  16进制码转换成8位byte型.----根据byte找到对应的ascii码
     * @param str
     * @return
     */
    public static char getAccis(String str){
    	int by = 0;
    	by = Integer.parseInt(str);
    	return (char)by;
    }
    
    /**
     * @描述	获取指定位置的XML文件解析   
     * @return
     */
	public static String getXmlFile(){
//		String xml = DataFormatter.getStringFromFile(DataFormatter.class.getClassLoader().getResource("com/bpms/interfaces/communicate/paycode/config/MsgTemplate.xml").getPath());
		return "";
	}
	
	/**
	 * @描述     支付密码获得返回结果的中文描述
	 * @param bu
	 * @return
	 */
	public static ERRINFO getError(int bu){
		ERRINFO error = null;
		switch (bu) {
			case 0x02:
				error = ERRINFO.日期非法;
				break;
			case 0x29:
				error = ERRINFO.付方帐号非法;
				break;
			case 0x2A:
				error = ERRINFO.支付密码校验时收方帐号非法;
				break;
			case 0x2B:
				error = ERRINFO.票据种类非法;
			break;
			case 0x2C:
				error = ERRINFO.票据号码非法;
				break;
			case 0x2D:
				error = ERRINFO.金额非法;
				break;
			case 0x2E:
				error = ERRINFO.支付密码非法;
				break;
			case 0x01:
				error = ERRINFO.数据库操作失败;
				break;
			case 0x06:
				error = ERRINFO.操作指令非法;
				break;
			case 0x31:
			case 0x32:
			case 0x33:
			case 0x34:
			case 0x35:
				error = ERRINFO.支付密码校验卡操作失败;
				break;
			case 0x3E:
				error = ERRINFO.数据库中信息错误;
			break;
			case 0x07:
				error = ERRINFO.无此机具号;
			break;
			case 0x08:
				error = ERRINFO.库中无此密码器帐号;
			break;
			case 0x14:
				error = ERRINFO.支付密码正确机具已停用;
			break;
			case 0x15:
				error = ERRINFO.支付密码正确机具已作废;
			break;
			case 0x16:
				error = ERRINFO.机具已注销;
			break;
			case 0x17:
				error = ERRINFO.支付密码正确机具状态非法;
			break;
			case 0x28:
				error = ERRINFO.支付密码正确账号已删除或密钥更改;
			break;
			case 0x27:
			case 0x30:
			case 0xA6:
				error = ERRINFO.支付密码错误;
			break;
			case 0x00:
				error = ERRINFO.支付密码正确;
			break;
			default :
				error = ERRINFO.未知错误;
			break;
		}
		return error;
	}
}
