package com.yyy.design.designModel2.polymorphicfactory;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午02:54:54
 * 
 * @类说明 ：具体工厂角色类
 */
public class ExportHtmlFactory implements ExportFactory {

	public ExportFile factory(String type) {
		// TODO Auto-generated method stub
		if ("standard".equals(type)) {

			return new ExportStandardHtmlFile();

		} else if ("financial".equals(type)) {

			return new ExportFinancialHtmlFile();

		} else {
			throw new RuntimeException("没有找到对象");
		}
	}

}
