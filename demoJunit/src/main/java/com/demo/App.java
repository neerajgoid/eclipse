package com.demo;

/**
 * Hello world!
 *
 */
public class App 
{
//    public static void main( String[] args )
//    {
//        System.out.println( "Hello World!" );
//    }
	
	public boolean isNum(String num)
	{
		try{
			Integer.parseInt(num);
			return true;	
		}
		catch(NumberFormatException e) { // this is an unchecked exception, thrown only runtime.

			System.out.println("Not a num");
			return false;
		}
		
	}
}
