package com.yyy.dailycode.timetask;

import java.util.Calendar;
import java.util.Date;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 *   @类名： DateTimerTask
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-1-14 上午11:20:07
 *   @修改人：
 *   @修改时间：  
 **/
public class DateTimerTask extends TimerTask{
	private Logger _log = Logger.getLogger(DateTimerTask.class);
	@Override
	public void run() {
		try{
			System.out.println("调用timetask的例子" + System.currentTimeMillis());
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, 13);
			calendar.set(Calendar.MINUTE, 32);
			calendar.set(Calendar.SECOND, 0);
			Date date = calendar.getTime();
			if(date.before(new Date())){
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.set(Calendar.MONTH, Calendar.MONTH + 1);
			}
		}catch(Exception e){
			_log.error("调用timetask出错", e);
		}
		
	}
	
}

