package com.springboot.bankingsystems.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentTimestamp {

	public static java.sql.Timestamp getCurrentTimeStamp() {

		java.util.Date today = new java.util.Date();
		return new java.sql.Timestamp(today.getTime());

	}
	public static Timestamp getTimestamp(String str) {
		try
		{
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
			Date parsedDate = dateFormat.parse(str);
			Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
			return timestamp;
		}
		catch(Exception e)
		{   
			System.out.println(e);
		}
		return null;
	}
}
