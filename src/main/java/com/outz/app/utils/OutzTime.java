package com.outz.app.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class OutzTime {

	public static String stampTimeNow(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date now = new Date();
		String nowString = dateFormat.format(now);
		return nowString;
	}
	
	public static String stampTime1Day(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, 1);  // number of days to add
		return dateFormat.format(calendar.getTime());  // dt is now the new date
	}
	
	public static String stampTimeDaysFromNow(int days){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
		Date now = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(now);
		calendar.add(Calendar.DATE, days);  // number of days to add
		return dateFormat.format(calendar.getTime());  // dt is now the new date
	}
	
}
