package com.workers.jdbcexample.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtilities {
	public static String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:SS");
		return dateFormat.format(new Date());
	}
}
