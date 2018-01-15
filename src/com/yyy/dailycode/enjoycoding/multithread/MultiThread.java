package com.yyy.dailycode.enjoycoding.multithread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * @类名： MultiThread
 * @描述： 多线程
 * @作者： 杨文胜
 * @生成时间： 2016-6-16 下午02:05:46
 * @修改人：
 * @修改时间：
 **/
public class MultiThread {
	private static final String URL = "https://www.baidu.com/";
	static int i = 0;

	/**
	 *   @类名： ExtendThread
	 *   @描述： 继承thread类
	 *   		1）可以将线程类抽象出来，当需要使用抽象工厂模式设计时。
	 *   		2）多线程同步
	 *   @作者： 杨文胜
	 *   @生成时间： 2016-6-16 下午02:12:47
	 *   @修改人：
	 *   @修改时间：  
	 **/
	public class ExtendThread extends Thread {
		public void run() {
			System.out.println(i++);
		}
	}

	/**
	 *   @类名： ImplementsRunnableThread
	 *   @描述： 实现Runnable接口
	 *   		1）适合多个相同的程序代码的线程去处理同一个资源
	 *			2）可以避免Java中的单继承的限制
	 *			3）增加程序的健壮性，代码可以被多个线程共享，代码和数据独立。
	 *   @作者： 杨文胜
	 *   @生成时间： 2016-6-16 下午02:13:15
	 *   @修改人：
	 *   @修改时间：  
	 **/
	public class ImplementsRunnableThread implements Runnable {
		public void run() {
			System.out.println(i++);
		}
	}

	public void testThreadPool() throws InterruptedException, ExecutionException {
		System.out.println("----程序开始运行----");
		Date date1 = new Date();

		int taskSize = 5;
		// 创建一个线程池
		ExecutorService pool = Executors.newFixedThreadPool(taskSize);
		// 创建多个有返回值的任务
		List<Future> list = new ArrayList<Future>();
		for (int i = 0; i < taskSize; i++) {
			Callable c = new MyCallable(i + " ");
			// 执行任务并获取Future对象
			Future f = pool.submit(c);
			// System.out.println(">>>" + f.get().toString());
			list.add(f);
		}
		// 关闭线程池
		pool.shutdown();

		// 获取所有并发任务的运行结果
		for (Future f : list) {
			// 从Future对象上获取任务的返回值，并输出到控制台
			System.out.println(">>>" + f.get().toString());
		}

		Date date2 = new Date();
		System.out.println("----程序结束运行----，程序运行时间【" + (date2.getTime() - date1.getTime()) + "毫秒】");

	}

	class MyCallable implements Callable<Object> {
		private String taskNum;

		MyCallable(String taskNum) {
			this.taskNum = taskNum;
		}

		public Object call() throws Exception {
			System.out.println(">>>" + taskNum + "任务启动");
			Date dateTmp1 = new Date();
			Thread.sleep(1000);
			Date dateTmp2 = new Date();
			long time = dateTmp2.getTime() - dateTmp1.getTime();
			System.out.println(">>>" + taskNum + "任务终止");
			return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
		}
	}
	/**
	 *   @生成时间： 2016-6-16 下午02:13:33
	 *   @方法说明： 无需继承thread或者实现Runnable，缩小作用域。
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void threadMethod() {
		Thread t = new Thread(new Runnable() {
			public void run() {
				System.out.println(i++);
				httpRequest();
			}
		});
		t.start();
	}
	
	/**
	 *   @生成时间： 2016-6-16 下午03:40:55
	 *   @方法说明： 模拟测试请求
	 *   @参数：
	 *   @返回值： 
	 *   @异常：
	 **/
	public void httpRequest(){
		com.yyy.dailycode.enjoycoding.getpost.HttpGetPost.sendGet(URL, null);
	}
	public static void main(String[] args) {
//		//内部类继承线程启动
//		MultiThread.ExtendThread extendThread1 = new MultiThread().new ExtendThread();
//		MultiThread.ExtendThread extendThread2 = new MultiThread().new ExtendThread();
//		extendThread1.start();
//		extendThread2.start();
//		
//		//内部类实现runbale接口线程启动
//		MultiThread.ImplementsRunnableThread runThread1 = new MultiThread().new ImplementsRunnableThread();
//		MultiThread.ImplementsRunnableThread runThread2 = new MultiThread().new ImplementsRunnableThread();
//		Thread thread1 = new Thread(runThread1);
//		Thread thread2 = new Thread(runThread2);
//		thread1.start();
//		thread2.start();
		
//		函数线程启动
//		MultiThread multiThread = new MultiThread();
//		multiThread.threadMethod();
//		multiThread.threadMethod();
		MultiThread multiThread = new MultiThread();
		for(int i=0;i<100;i++){
			multiThread.threadMethod();
		}
		
		
	}
}
