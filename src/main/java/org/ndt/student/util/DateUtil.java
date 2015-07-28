package org.ndt.student.util;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class DateUtil 
{
	public  static java.util.Date convertSqlToUtil(java.sql.Date sqlDate)
	{
		java.util.Date convertedDate = new java.util.Date(sqlDate.getTime());
		return convertedDate;
	}
	
	public static java.sql.Date getDate()
	{
		 java.util.Date utilDate = new java.util.Date();
		 java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		 return sqlDate;
	}
	
	public static java.sql.Date convertJavaDateToSqlDate(java.util.Date date)
	{
	    return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Date getNext365DaysDate(String dateString)	
	   {
		   java.sql.Date next365DaysDate = null;
		   if(dateString.isEmpty() || dateString == null)
		   {
			   
		   }
		   else
		   {
			   SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd");
			 
			   try 
			   {
				   Date date = formater.parse(dateString);
				   Calendar cal = Calendar.getInstance();  
				   cal.setTime(date);
				   cal.add(cal.DATE, 365);
				   DateUtil dc = new DateUtil();
				   next365DaysDate= dc.convertJavaDateToSqlDate(cal.getTime());
			   } 
			   catch (ParseException e) 
			   {
				   e.printStackTrace();
			   }
		   }
		return next365DaysDate;
	   }
	
	
	public static String simpleDateFormater (java.util.Date date)
	{
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String sqldate = df.format(date);
		return sqldate;
		
	}
}
