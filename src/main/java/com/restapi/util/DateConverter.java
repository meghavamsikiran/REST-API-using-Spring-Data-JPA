package com.restapi.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateConverter {
	
	public static java.sql.Date convertStringToSQLDate(String stringDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date convertedDate = null;
		convertedDate= new java.sql.Date(sdf.parse(stringDate).getTime());
//		alternate way for above line
//		java.util.Date d1 = sdf.parse(stringDate);
//		long d1InSecs = d1.getTime();
//		convertedDate = new java.sql.Date(d1InSecs);
		return convertedDate;
	}
}
