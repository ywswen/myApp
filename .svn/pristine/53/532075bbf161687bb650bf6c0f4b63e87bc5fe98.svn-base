package com.test.updatexml;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.xml.sax.InputSource;

import com.yyy.dailycode.log.SinoLogger;

/**
 *  @类名： CreateXml
 *  @描述： 获取路径文件的两种方法
 *  	   1：class.getResource(XML_LOCATION_EXCHANGE).getPath()，获取的是编译后的路径
 *  		  例如：/com/test/updatexml/FromAB.xml
 *  	   2：直接文件路径获取，例如：src/com/test/updatexml/EXCNAGEFromAB.xml
 *  @作者： 杨文胜
 *  @生成时间： 2013-11-18 下午04:26:28
 *  @修改人：
 *  @修改时间：
 */
public class Dom4jReadWriterXML {
	private static final SinoLogger _log = SinoLogger.getLogger(Dom4jReadWriterXML.class);
	private static final String XML_LOCATION = "/com/test/updatexml/FromAB.xml";
	private static final String XML_LOCATION_EXCHANGE = "src/com/test/updatexml/EXCNAGEFromAB.xml";
	private static final String SRC_OLD = "src_old";
	private static final String FIELD_NAME = "field-Name";
	private static final String FIELD_CONTENT = "field";
	private static final String BLANK = "";
	/**
	 * @属性说明：FIELD_NAME在此xml中的个数
	 **/
	private static int filedCount = 0;
	/**
	 *   @生成时间： 2013-11-18 下午04:27:17
	 *   @方法说明： 构建需要的xml
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void packXml(){
		SAXReader reader = new SAXReader();
		try {
			InputStream input = Dom4jReadWriterXML.class.getResourceAsStream(XML_LOCATION);
			Document doc = reader.read(new InputSource(input));
			Element root = doc.getRootElement();
			_log.info("开始转换xml文件......");
			recurseElement(root);
			_log.info("转换xml文件成功！");
			writeXML(doc);
		} catch (Exception e) {
			_log.error("xml读取错误！", e);
		}
	}
	/**
	 *   @生成时间： 2013-11-18 下午05:25:09
	 *   @方法说明： 将xml写入文件
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void writeXML(Document doc){
		FileWriter fileWriter = null;
		try {
			_log.info("开始写入xml文件.....");
//			String filePath = Dom4jReadWriterXML.class.getResource(XML_LOCATION_EXCHANGE).getPath();
			fileWriter = new FileWriter(XML_LOCATION_EXCHANGE);
			OutputFormat format = OutputFormat.createPrettyPrint();
			XMLWriter xmlWriter = new XMLWriter(System.out, format);
			xmlWriter.setWriter(fileWriter);
			xmlWriter.write(doc);
			xmlWriter.flush();
			xmlWriter.close();
			_log.info("写入xml文件成功！");
		} catch (IOException e) {
			_log.error("xml写入错误！", e);
		} finally{
			if(null != fileWriter)
				try {
					fileWriter.close();
				} catch (IOException e) {
					_log.error("xml关闭错误！", e);
				}
		}
	}
	/**
	 *   @生成时间： 2013-11-18 下午04:51:53
	 *   @方法说明： 递归修改xml文件
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@SuppressWarnings("unchecked")
	public static void recurseElement(Element element){
		List<Element> chilDrenElement = element.elements();
		int size = chilDrenElement.size();
		if(chilDrenElement.size() < 1){
			String xpath = element.getPath();
			String elementName = element.getName();
			if(StringUtils.isNotEmpty(elementName) && elementName.indexOf(FIELD_CONTENT) != -1){
				if(elementName.indexOf(FIELD_NAME) != -1){
					filedCount++;
				}
				xpath = xpath.replaceFirst(FIELD_CONTENT, FIELD_CONTENT + "[" + filedCount + "]") ;
			}
			element.setText(BLANK);
			element.addAttribute(SRC_OLD, xpath);
		}else{
			for(int i=0;i<size;i++){
				recurseElement(chilDrenElement.get(i));
			}
		}
	}
}

