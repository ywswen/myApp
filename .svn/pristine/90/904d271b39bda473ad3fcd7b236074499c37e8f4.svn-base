package com.yyy.dailycode.timetask;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 *   @类名： TimerManager
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-1-14 上午11:08:05
 *   @修改人：
 *   @修改时间：  
 **/
public class TimerManager {
//	private static final long PERIOD_DAY = 24 * 60 * 60 *1000;
	private static final long PERIOD_DAY = 1000;
		public TimerManager(){
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 13);
			calendar.set(Calendar.MINUTE, 32);
			calendar.set(Calendar.SECOND, 0);
			Date date = calendar.getTime();
			if(date.before(new Date())){
				date = this.addDay(date, 1);
			}
			Timer timer = new Timer();
			DateTimerTask task = new DateTimerTask();
			System.out.println(date);
			timer.schedule(task, date, PERIOD_DAY);
		}
		public Date addDay(Date date, int num){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(Calendar.DAY_OF_MONTH, num);
			return calendar.getTime();
		}
}

