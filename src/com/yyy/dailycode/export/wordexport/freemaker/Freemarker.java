package com.yyy.dailycode.export.wordexport.freemaker;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yyy.util.FileUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 *   @类名： Freemarker
 *   @描述： 模板引擎类
 *   @作者： 杨文胜
 *   @生成时间： 2014-6-3 下午05:32:42
 *   @修改人：
 *   @修改时间：  
 **/
public class Freemarker {
	private static final Logger log = Logger.getLogger(Freemarker.class);
	private static final String FILE_SEPARATOR = File.separator;
	/**
	 * @属性说明：模板目录
	 **/
	private static final String WORD_TEMPLATE = "/resources/wordtemplate";
	/**
	 * @属性说明：项目的word模板路径
	 **/
	private static final String PROJECT_PATH = Freemarker.class.getResource(WORD_TEMPLATE).getPath();
	/**
	 * @属性说明：编码格式
	 **/
	private static final String ENCODING = "utf-8";
	/**
	 * @属性说明：数字格式
	 **/
	private static final String NUMBER_FORMAT = "#";
	/**
	 * @属性说明：文件类型为doc
	 **/
	private static final String FILE_TYPE = ".doc";
	private static Configuration configuration = null;  
	/**
	 *   @作者： 杨文胜
	 *   @生成时间： 2014-6-3 下午05:43:12
	 *   @修改人：
	 *   @修改时间： 
	 *   @方法描述： 私有构造方法
	 *   @param
	 **/
	private Freemarker(){}
	/**
	 *   @生成时间： 2014-6-3 下午05:38:04
	 *   @方法说明： 单例模式加载模板
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static Configuration getInstance(){
		if(configuration == null) {
			configuration = new Configuration();
			configuration.setDefaultEncoding(ENCODING);  
			configuration.setNumberFormat(NUMBER_FORMAT);//设置数字格式化方式
			 try {
				configuration.setDirectoryForTemplateLoading(new File(PROJECT_PATH));
			}  catch (Exception e) {
				log.error("加载模板引擎失败", e);
			}
		}
		return configuration;
	}
	
	/**
	 * 根据模版、参数生成word文件
	 * @param map
	 * @param templateFile
	 * @return
	 * @throws TxnErrorException
	 */
	public static String createWord(Map<String, String> map,String templateFile) throws Exception{
		String file_path =null;
		try {
			Template template = Freemarker.getInstance().getTemplate(templateFile);
			template.setEncoding(ENCODING);
			file_path = PROJECT_PATH + FILE_SEPARATOR + FileUtil.getRandomFileName() + FILE_TYPE;
			File file = new File(file_path);
			Writer   out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));  
			template.process(map, out);
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (TemplateException e) {
			e.printStackTrace();
		}
		return file_path;
	}
	/**
	 * 批量生成word文件
	 * @param map freemark所需参数值
	 * @param templateFile freemark模版
	 * @param filname  生成文件名称
	 * @param filePath 生成文件路径
	 * @return
	 * @throws TxnErrorException
	 */
	public static String createWordBatch(Map<String, String> map,String templateFile,String filePath,String filname) throws Exception{
		try {
			Template template = Freemarker.getInstance().getTemplate(templateFile);
			template.setEncoding(ENCODING);
			File file = new File(filePath);
			if(!file.exists()){
				file.mkdirs();
			}
			String file_path = filePath + FILE_SEPARATOR +filname + FILE_TYPE;
			file = new File(file_path);
			//判断导出数据中同一单位下是否有重名现象
			while(file.exists()){
				file_path = filePath + FILE_SEPARATOR +filname+(int)(Math.random()*100) + FILE_TYPE;
				file = new File(file_path);
			}
			Writer   out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), ENCODING));  
			template.process(map, out);
			out.close(); 
		} catch (IOException e) {
			e.printStackTrace();
		}  catch (TemplateException e) {
			e.printStackTrace();
		}
		return filePath;
	}
}
