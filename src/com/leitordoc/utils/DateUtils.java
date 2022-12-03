package com.leitordoc.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	public static Date stringToDate (String dataString) throws ParseException {
		if (dataString == null || dataString.length() < 4) {
			dataString = "01/01/0001";
		}
	    Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataString);  
	    return date;
	}
	
	public static Date[] chronologizeDates (Date data1, Date data2) {
		Date[] output = new Date[2];
		if(data1.after(data2)) {
		    output[0] = data2;
		    output[1] = data1;
		} else {
			output[0] = data1;
			output[1] = data2;
		}
		return output;
	}
}
