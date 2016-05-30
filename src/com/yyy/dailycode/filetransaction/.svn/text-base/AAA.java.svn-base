package com.yyy.dailycode.filetransaction;

import java.io.File;

import junit.framework.TestCase;

import org.apache.commons.transaction.file.FileResourceManager;
import org.apache.commons.transaction.util.Log4jLogger;
import org.apache.commons.transaction.util.LoggerFacade;
import org.apache.log4j.Logger;

/**
 *   @类名： AAA
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-8-13 下午05:38:23
 *   @修改人：
 *   @修改时间：  
 **/
public class AAA extends TestCase{
	private static Logger _log = Logger.getLogger(AAA.class);
	private static LoggerFacade loggerFacade = new Log4jLogger(_log);
	public void testConn() throws Exception{
		try {
			String toDir = "c:" + File.separator + "imageroot" + File.separator	+ "a";//"C:\\imageroot\\20130815\\002\\0002\\00\\00200020020130815022432000000103";
			String tempDir = "c:\\imageroot\\wordDir";
			FileResourceManager frm = new FileResourceManager(toDir, tempDir,
					false, loggerFacade);
			frm.start();
			String txId = frm.generatedUniqueTxId();
			try {
				frm.startTransaction(txId);
//				frm.deleteResource(txId, "201308150000002626");
////				frm.deleteResource(txId, "2.txt");
//				frm.createResource(txId, "1.txt");
//				OutputStream out = frm.writeResource(txId, "1.txt");
//				byte []b = "aaa哈哈".getBytes();
//				out.write(b);
//				out.flush();
//				out.close();
//				int i = 1/0;
				frm.commitTransaction(txId);
				System.out.println("aaaaa");
			} catch (Exception e) {
				frm.rollbackTransaction(txId);
				e.printStackTrace();
			}
			frm.stop(FileResourceManager.SHUTDOWN_MODE_NORMAL);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

