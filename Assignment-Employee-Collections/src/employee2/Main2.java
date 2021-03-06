package employee2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int choice;
		HashMap<Emp, Emp> hm = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		do
		{
			System.out.println("enter your choice 1.add employee 2. sort employee 3.Search Employee 4.Display ");
			
		     choice = sc.nextInt();
			
			
			if(choice == 1)
			{
				System.out.println("Enter your name");
				String name = sc.next();
				System.out.println("Enter your age");
				int age = sc.nextInt();
				System.out.println("Enter your salary");
				int salary = sc.nextInt();
				int id;
				int count=1;
				
				Iterator<Emp> itr = hm.keySet().iterator();
				while(itr.hasNext())
				{
					Emp emp = (Emp) itr.next();
					
					if(emp.getName().equals(name))
					{
						count++;
					}
				}
				
				id=count;
				Emp e = new Emp(id, name, age, salary);
				hm.put(e,e);
				
			}
			if(choice == 3 )
			{
				System.out.println("Enter the name you want to search for");
				String name = sc.next();
				System.out.println("Enter the ID you want to search for");
				int id = sc.nextInt();
				
				
				//Iterator<Map.Entry<Emp, Emp>> itr = hm.entrySet().iterator();
				Emp e = new Emp(id, name, 0, 0);
				
				Emp temp= hm.get(e); // 'e' is the key. it checks if key.equals(e) 
				           // in our equals() function we are checking only for name and id, 
				           //hence if those are a match then we get the value . 
						   // our equals function doesnt depend on the age and salary
				
				if(temp==null)
					System.out.println("not in database");
				else
					System.out.println("Name: "+ temp.getName() +" id:"+ temp.getId() +" age:" + temp.getAge()+"salary: "+ temp.getSalary());
				
			}
			if(choice == 4)
			{
				for(Map.Entry<Emp, Emp> me : hm.entrySet())
				{
					Emp emp = (Emp) me.getKey();
					Emp emp1 = (Emp) me.getValue();
					System.out.println("Key(Name,ID,Age,Salary): " + emp.getName() +" "+ emp.getId()+" "+ emp.getAge()+" "+ emp.getSalary());
					System.out.println("Value(Name,ID,Age,Salary): " + emp1.getName() +" "+ emp.getId()+" "+ emp.getAge()+" "+ emp.getSalary());
				}
			}
			
			
			
		}while(choice<=4);	
	}

}
