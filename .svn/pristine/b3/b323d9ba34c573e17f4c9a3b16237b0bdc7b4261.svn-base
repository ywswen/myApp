package com.yyy.dailycode.enjoycoding.timer;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 *   @类名： TimerManager
 *   @描述： time管理类
 *   @作者： 杨文胜
 *   @生成时间： 2014-6-3 上午11:13:29
 *   @修改人：
 *   @修改时间：  
 **/
public class TimerManager {
	/**
	 *   @作者： 杨文胜
	 *   @生成时间： 2014-6-3 上午11:13:37
	 *   @修改人：
	 *   @修改时间： 
	 *   @方法描述： 构造函数，执行任务调度
	 *   @param
	 **/
	public TimerManager() {
		// Calendar calendar_lj = Calendar.getInstance();
		// if(calendar_lj.get(Calendar.MINUTE)>=30){
		// calendar_lj.set(Calendar.MINUTE, 60);
		// }else{
		// calendar_lj.set(Calendar.MINUTE, 30);
		// }
		// calendar_lj.set(Calendar.SECOND, 0);
		// /*** 定制每日执行方法 ***/
		//
		// //// calendar_lj.set(Calendar.HOUR_OF_DAY, 0);
		// //// calendar_lj.set(Calendar.MINUTE, 26);
		// // calendar_lj.set(Calendar.SECOND, 1);
		// Date date51=calendar_lj.getTime();
		Calendar calendar_gl = Calendar.getInstance();

		/*** 定制每日执行方法 ***/
		calendar_gl.set(Calendar.MONTH, Calendar.DECEMBER);
		calendar_gl.set(Calendar.DAY_OF_MONTH, 31);
		calendar_gl.set(Calendar.HOUR_OF_DAY, 23);
		calendar_gl.set(Calendar.MINUTE, 59);
		calendar_gl.set(Calendar.SECOND, 59);

		Date dategl = calendar_gl.getTime(); // 第一次执行定时任务的时间
		Timer timer = new Timer();
		timer.schedule(new TimeSchedule(), dategl, 1 * 60 * 1000);
	}
	public static void main(String[] args) {
		new TimerManager();
	}
}
