package com.yyy.dailycode.stack;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import junit.framework.TestCase;

import org.apache.log4j.Logger;

/**
 *   @类名： Stacks
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-1-4 下午03:48:17
 *   @修改人：
 *   @修改时间：  
 **/
public class Stacks extends TestCase{
	private Logger _log = Logger.getLogger(Stacks.class);
	static String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
	@SuppressWarnings("unchecked")
	public void testStacks(){
		_log.info("------堆栈调用开始-----");
		Stack stack = new Stack();
		for(int i =0;i<months.length;i++){
			stack.push(months[i]);
		}
		while(!stack.empty()){
			System.out.println(stack.pop());
		}
		Iterator iterator = stack.iterator();
		while(iterator.hasNext()){
			String month = (String)iterator.next();
			System.out.println(month);
		}
		_log.info("------堆栈调用结束-----");
		List list = new ArrayList();
		list.add("January");
		list.add("February");
		list.add("March");
		System.out.println(list);
	}
	public void testFor(){
		
		for(int i=0;i<5;i++){
			outer:
			for(int j=0;j<5;j++){
				if(j*i>9){
					continue  outer;
				}else{
					System.out.println("i=:" + i + "   k=" + j);
				}
				
			}
		}
	}
}

