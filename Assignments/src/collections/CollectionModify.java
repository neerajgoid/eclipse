package collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class CollectionModify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ch;
		List<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(5);
		list.add(8);
		list.add(7);
		list.add(6); //2,5,8,7,6,4,3.
		list.add(4);
		list.add(3);
		
		do { 
		
			System.out.println("Enter choice 1.Foreach 2.For 3.Iterator");
			ch = sc.nextInt();
			
			switch(ch)
			{
			case 1: for(Integer i: list) {
						
						if(i%2==0) {
							
							System.out.println("Element:" + i);
						}
						else {
							list.remove(i);  
							// NOTE : Collections cannot be modified in Foreach Loop. Only Iterator. 
						   // gives error like concurrent somethingsomething
					System.out.println("Size is now " + list.size());
						}
							
					}
			
					break;
			case 2: for(int i=0;i<list.size();i++) {
				
						if((list.get(i))%2==0) {
					
								System.out.println("Element:" + list.get(i));
						}
						else {
								list.remove(list.get(i));
								// NOTE : coz no of iterations are gonna remain the same even if no of elements reduce.
								// Gives wrong output here.  
						}
					
					}
					break;
					
			case 3: Iterator<Integer> itr = list.iterator();
				
					while(itr.hasNext())
					{
						int num = itr.next();
								
						if((num%2)==0) { 
							
							System.out.println("Element:" + num+"is an even number ");
					}
					else {
							//list.remove(num);  // NOTE : Collections cannot be modified in Foreach Loop. Only Iterator. 
						//	list.remove(num); // Wrong coz removing from index 'num' and not the value 'num' from list.
							itr.remove();  // right coz avoids a ConcurrentModificationException
							System.out.println("Element removed is:" +num +" Size is now " + list.size());
					}
					}
			}
		}while(ch!=4);
		
		
		

	}

}
