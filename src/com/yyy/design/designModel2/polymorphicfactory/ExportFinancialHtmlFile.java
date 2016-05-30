package com.yyy.design.designModel2.polymorphicfactory;


/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午02:54:54
 * 
 * @类说明 ：导出财务版HTML文件
 */
public class ExportFinancialHtmlFile implements ExportFile {

	public boolean export(String data) {
		// TODO Auto-generated method stub
		/**
		 * 业务逻辑
		 */
		System.out.println("导出财务版HTML文件");
		return true;
	}

}
