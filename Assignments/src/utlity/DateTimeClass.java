package utlity;

//import java.sql.Date;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DateTimeClass {

	public static void main(String[] args) throws InterruptedException, ParseException {
		// TODO Auto-generated method stub

	
		Date date = new Date(1000000000);
		Date date1 = new Date(500000000);
		if(date.before(date1)) {
	//		System.out.println("Date:" + date.toString() +"is before"+ date1.toString());
		}
		else{
		//	System.out.println("Date:" + date.toString() +"is after "+ date1.toString());
		}
		
	//	Date date2 = new Date();
		//Date date3 = new Date();
		
		
		TimeZone tz = TimeZone.getTimeZone("US/Hawaii");
		
		TimeZone.setDefault(tz);
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(tz);
		//cal.setTimeZone("US?Hawaii");
		System.out.println(cal.getTime());
		System.out.println("*********************");
		
		
		//Thread.sleep(500);
		
//		System.out.println("Current date and time is:" + date2.toString());
//		//Thread.sleep(10000);
//		System.out.println("Date and time after sleeping is:" + date3.toString());
//		
//		
//		System.out.println("date is:" + date.toString());
//		System.out.println("date1 is:" + date1.toString());
//		
//		
//		
//		SimpleDateFormat sdf = new SimpleDateFormat();
//		sdf.applyPattern("dd/MM/yyyy");
//		System.out.println("Date is:" + sdf.format(date));
//		
//		
//		String sDate1="31/12/1998";  
//	    Date date4=new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);  
//	    System.out.println(sDate1+"\t"+date1); 
	    
	}

}
