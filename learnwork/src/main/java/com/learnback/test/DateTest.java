package com.learnback.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Date date=new Date(1452527999109l);
		System.out.println(date);
		
		Date date1=new Date(1452182399000l);
		System.out.println(date1);
		
		
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date2=format.parse("2015-12-01 23:59:59");
		System.out.println(date2);
		System.out.println(date2.getTime());
	}

}
