package hashmapp;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NullHMCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		hm.put(null, null);
		hm.put(1, null);
		//hm.put(null, 2);
		// Note : 1 null key allowed and multiple null values
		for(Map.Entry<Integer, Integer> entry : hm.entrySet())
		{
			System.out.println("Key:"+ entry.getKey() + "Value:" + entry.getValue());
		}
	}

}
