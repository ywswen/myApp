package com.yyy.design.designModel2.polymorphicfactory;

/**
 * @author: 特种兵—AK47
 * @创建时间：2012-6-19 下午02:54:54
 * 
 * @类说明 ：导出标准PDF文件
 */
public class ExportStandardPdfFile implements ExportFile {

	public boolean export(String data) {
		// TODO Auto-generated method stub
		/**
		 * 业务逻辑
		 */
		System.out.println("导出标准PDF文件");
		return true;
	}

}