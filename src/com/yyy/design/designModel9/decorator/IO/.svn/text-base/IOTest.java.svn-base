package com.yyy.design.designModel9.decorator.IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import com.yyy.design.designModel9.decorator.IO.imagebyte.IImageByte;
import com.yyy.design.designModel9.decorator.IO.imagebyte.ImageByteImpl;
import com.yyy.design.designModel9.decorator.IO.imagebyte.ImageByteProxy;

/**
 *   @类名： IOTest
 *   @描述： 装饰模式实现IO模式
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-26 下午04:08:55
 *   @修改人：
 *   @修改时间：  
 **/
public class IOTest {
	private static IImageByte i;
	static{
		ImageByteImpl ib =new ImageByteImpl();
		ImageByteProxy proxy = new ImageByteProxy(ib);
		i = (IImageByte)proxy.getProxyInstance();
	}
	private static String filePath = "c:\\1.jpg";
	private static String txtPath = "c:\\1.txt";
	private static String destinationPath = "c:\\2.jpg";
	public static void fileToTxt(String fromPath,String toPath){
		FileInputStream dis = null;
		FileOutputStream dos = null;
		try{
			//dis = new DataInputStream(new BufferedInputStream(
				//	new FileInputStream(fromPath)));
			dis = new FileInputStream(fromPath);
			int length = dis.available();
			byte[] b = new byte[length];
			byte[] c = new byte[length];
			dis.read(b);
			File file = new File(toPath);
			if(!file.exists()) {
				file.createNewFile();
			}
			c = i.imageToByte(b);
			dos = new FileOutputStream(toPath);
			dos.write(c);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		fileToTxt(filePath,txtPath);
		fileToTxt(txtPath,destinationPath);
	}
}
