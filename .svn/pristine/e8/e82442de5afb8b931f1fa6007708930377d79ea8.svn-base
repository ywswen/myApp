package com.yyy.dailycode.export.wordexport.freemaker;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestFreeMarker {
	private static final Logger log = Logger.getLogger(TestFreeMarker.class);
	/**
	 *   @生成时间： 2014-6-4 上午11:25:53
	 *   @方法说明： 测试创建Word模板
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	@Test
	public void createDocFileByTemplate(){
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "杨文胜");
		params.put("department", "综合交付二部");
		try {
			Freemarker.createWord(params, WordTemplateName.GZ_BDTZD);
		} catch (Exception e) {
			log.error("创建模板失败", e);
		}
	}
}
