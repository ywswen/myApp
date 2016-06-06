package com.yyy.design.designModel2.polymorphicfactory;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午02:55:04
 * 
 * @类说明 ：具体工厂角色类
 */
public class ExportPdfFactory implements ExportFactory {

	public ExportFile factory(String type) {
		if ("standard".equals(type)) {

			return new ExportStandardHtmlFile();

		} else if ("financial".equals(type)) {

			return new ExportFinancialHtmlFile();

		} else {
			throw new RuntimeException("没有找到对象");
		}
	}

}
