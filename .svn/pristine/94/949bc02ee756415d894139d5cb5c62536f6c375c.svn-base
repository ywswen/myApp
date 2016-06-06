package com.yyy.design.designModel9.decorator.IO.imagebyte;

import com.test.ReadDbConfig;


/**
 *   @类名： ImageByteImpl
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2012-11-27 下午04:18:54
 *   @修改人：
 *   @修改时间：  
 **/
public class ImageByteImpl implements IImageByte{
	public byte[] imageToByte(byte[] b) {
		// TODO Auto-generated method stub
		int length = b.length;
		byte[] c = new byte[length];
		for(int i =0;i<length;i++){
			c[length-1-i] = b[i];
		}
		return c;
	}
	public boolean ownMethod(){
		boolean ret = false;
		System.out.println("it's my own method!");
		try{
			new ReadDbConfig().getProp(ImageByteImpl.class.getName());
			ret = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return ret;
	}
}

