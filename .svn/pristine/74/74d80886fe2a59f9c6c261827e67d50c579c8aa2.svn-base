package com.yyy.dailycode.outofemory;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名： MemoryTest
 * @描述：
 * @作者： 杨文胜
 * @生成时间： 2013-1-4 下午04:46:28
 * @修改人：
 * @修改时间：
 */
public class MemoryTest {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List list = new ArrayList();
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < 10000000; i++) {
			list.add(i);
			if (i == 100000) {
				list.clear();
				System.gc();
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("End.. : " + endTime + " Cost : "
				+ (endTime - startTime));
	}
	// public static void main(String[] args) {
	// for(int i=0;i<10000000;i++){
	// Stack stack = new Stack();
	// stack.push("23fdsaf"+i);
	// System.out.println(i);
	// }
	// // new Thread(new MemoryLeak(), "Memory leak ").start();
	// }
}

class MemoryLeak implements Runnable {
	public List<Integer> list = new ArrayList<Integer>();

	public void run() {
		int num = 0;
		num++;
		Integer i = new Integer(num);
		list.add(i);
		while (true) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException interruptedException) {
				interruptedException.printStackTrace();
			}
		}
	}

}
