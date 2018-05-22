package com.aiteachu.morinaga.component;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	private final static String DATE_FORMAT = "yyyyMMdd";
	
	public static String getToday(){
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return sdf.format(new Date());
	}
}
