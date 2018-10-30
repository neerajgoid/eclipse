package utlity;

import java.util.Formatter;
import java.util.Locale;

public class Locle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Locale loc = new Locale("fr");
		Locale locale2 = new Locale("fr", "CANADA");
		System.out.println("locale2: "+locale2);
		
		Locale locale3 = new Locale("no", "NORWAY", "NY");
		System.out.println("locale3: "+locale3);

		
		Locale[] localelist = Locale.getAvailableLocales();
		for(Locale l1 : localelist)
		{
			System.out.println("Local Name: "+ l1.getLanguage());
		}
		//System.out.println("Locale Lang:" + loc.getCountry());
		
//FORMATTER ******************************************
		
		String abc = "India";
		Formatter f = new Formatter();
		System.out.println(f.format("I am neeraj Godani,Welcome to %s", abc));
		
	}

}
