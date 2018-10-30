package utlity;

import java.util.StringTokenizer;

public class StrToken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String name = "I am Neeraj Goidani";
		StringTokenizer st = new StringTokenizer(name);
		StringTokenizer st1 = new StringTokenizer(name, "a");
		
		while(st.hasMoreTokens())
			System.out.println(st.nextToken());
		
		System.out.println("**********************");
		while(st1.hasMoreTokens())
			System.out.println(st1.nextToken());
		
	}

}
