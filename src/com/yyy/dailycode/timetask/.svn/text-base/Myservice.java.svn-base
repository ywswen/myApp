package com.yyy.dailycode.timetask;
/**
 *   @类名： Myservice
 *   @描述： 
 *   @作者： 杨文胜
 *   @生成时间： 2013-1-14 上午09:59:28
 *   @修改人：
 *   @修改时间：  
 **/
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.LinkedBlockingQueue;

public class Myservice{
   private Queue<String> logs = new LinkedBlockingQueue<String>(10000);
//   private DBProvider provider;
   private Timer timer;
   private LogToDbTask task; 
   private final long interval = 60 * 1; 

   public Myservice(){
//     provider= new DBProvider();
     timer= new Timer();
   }

   private void saveToDb(){
         String logstr=null;
         boolean suc=false;
         System.out.println("time  is " + new Date());
         for(int i=0;i<100 && !logs.isEmpty();i++){
              logstr=logs.poll();
              if(logstr!=null){
            	  System.out.println("time  is " + new Date());
//                 suc=provider.save(logstr);
                 if(!suc){
                    logs.add(logstr);
                 }
              }
         }
   }

   private class LogToDbTask extends TimerTask{
          public void run(){
                 saveToDb();
          }
   } 

   public void start(){
       task = new LogToDbTask();
       SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
       Date date;
		try {
			date = sf.parse("2013-01-14 10:21:00");
			timer.schedule(task,date,interval);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   }

   public static void main(String args[]){       
        Myservice service = new Myservice();
        service.start();
   }

}
