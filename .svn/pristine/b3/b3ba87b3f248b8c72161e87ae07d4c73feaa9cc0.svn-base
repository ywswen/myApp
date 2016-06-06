package com.yyy.projectcode.cetc.xxcj.filecharset;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import org.apache.log4j.Logger;


/**
 *   @类名： GetFileCharset
 *   @描述： 获取文件的编码格式
 *   @作者： 杨文胜
 *   @生成时间： Aug 1, 2014 5:15:52 PM
 *   @修改人：
 *   @修改时间：  
 **/
public class GetFileCharset {
	private static final Logger log = Logger.getLogger(GetFileCharset.class);
	/**
	 * @属性说明：GBK编码格式
	 **/
	private static final String GBK_CHARSET = "GBK";
	/**
	 * @属性说明：UTF-8编码格式
	 **/
	private static final String UTF8_CHARSET = "UTF-8";
	/**
	 * @属性说明：UTF-16编码格式
	 **/
	private static final String UTF16_CHARSET = "UTF-16";
	/**
	 * @属性说明：文件磁盘位置
	 **/
	private static final String FILEPATH = "d:\\复件 北京八月出口.csv";
	/**
	 *   @生成时间： Aug 1, 2014 5:26:26 PM
	 *   @方法说明： 测试文件编码格式
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static void main(String[] args) {
		File sourceFile = new File(FILEPATH);
		System.out.println(getFilecharset(sourceFile));
	}
	/**
	 *   @生成时间： Aug 1, 2014 5:26:16 PM
	 *   @方法说明： 获取文件编码格式
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public static String getFilecharset(File sourceFile) {
		String charset = GBK_CHARSET;
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(
					new FileInputStream(sourceFile));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1) {
				return charset; //文件编码为 ANSI
			} else if (first3Bytes[0] == (byte) 0xFF
					&& first3Bytes[1] == (byte) 0xFE) {
				charset = UTF16_CHARSET; //文件编码为 Unicode，实际为UTF-16LE，对应java解析使用的utf-16
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE
					&& first3Bytes[1] == (byte) 0xFF) {
				charset = UTF16_CHARSET; //文件编码为 Unicode big endian,实际为UTF-16BE，对应java的utf-16
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF
					&& first3Bytes[1] == (byte) 0xBB
					&& first3Bytes[2] == (byte) 0xBF) {
				charset = UTF8_CHARSET; //文件编码为 UTF-8
				checked = true;
			}
			bis.reset();
			if (!checked) {
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 0xF0)
						break;
					if (0x80 <= read && read <= 0xBF) // 单独出现BF以下的，也算是GBK
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) // 双字节 (0xC0 - 0xDF)
							// (0x80
							// - 0xBF),也可能在GB编码内
							continue;
						else
							break;
					} else if (0xE0 <= read && read <= 0xEF) {// 也有可能出错，但是几率较小
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = UTF8_CHARSET;
								break;
							} else
								break;
						} else
							break;
					}
				}
			}
			bis.close();
		} catch (Exception e) {
			log.error("获取文件编码失败，默认返回GBK的编码", e);
		}
		return charset;
	}
}
