package treemapp;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TmSortingValue { //Tm - TreeMap

	public static void main(String[] args) {
		// TODO Auto-generated method stub
              
		Map<TmEmployee, TmEmployee> tm = new TreeMap<>();
		
		
		TmEmployee tme1 = new TmEmployee("Neeraj", 10);
		TmEmployee tme2 = new TmEmployee("Neeraja", 20);
		TmEmployee tme3 = new TmEmployee("Akash", 30);
		
		
		tm.put(tme1, tme1);
		tm.put(tme2, tme2);
		tm.put(tme3, tme3);
		
		
		Iterator<Map.Entry<TmEmployee, TmEmployee>> itr = tm.entrySet().iterator();
		
		while(itr.hasNext())
		{
			TmEmployee temp = (TmEmployee) itr.next().getKey();
			System.out.println("Name:" + temp.getName() +" " + "Salary:" + temp.getSalary());
		}
	}

}