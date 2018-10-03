package com.globant.neeraj.assignments;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main
{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Employee> al = new ArrayList<>(); 
		int ch;
		do
		{	
		System.out.println("Enter your choice 1. Add Employee 2.Sort Employee 3.Find Employee 4.Exit ");
		ch = sc.nextInt();
	
		if(ch==1)
		{	
			System.out.println("Enter no of users");
			int num = sc.nextInt();
		
		
		for(int i=0;i<num;i++)
		{
			System.out.println("Enter name");
			String inputName = sc.next();
			System.out.println("Enter age");
			int inputAge = sc.nextInt();
			//int newId=0;
			Iterator<Employee> itr = al.iterator();
			int id=001;
			while(itr.hasNext()){
					Employee e = (Employee) itr.next();
				if(e.getName().equals(inputName)){
					id++;
				}
	
			}
			
			al.add(new Employee(inputName, id, inputAge));
		 
		}
		
		}
		
		else if(ch==2) {
		Collections.sort(al);
		display(al);
		}
		else if(ch==3) {
		search(al);
		}
		else
		{
			System.out.println("Chosen to exit");
		}
		}while(ch!=4);
	}
	
	public static void display(ArrayList<Employee> al) {
		Iterator<Employee> itr = al.iterator(); 
		System.out.println("******List in Sorted order by Age");
		while(itr.hasNext())
		{
			Employee e = (Employee) itr.next();
			System.out.println("Employee details: Name:" + e.getName() +"Age:"+ e.getAge() +"Id:"+ e.getId());
		}
		
	}
	
	public static void search(ArrayList<Employee> al) {
		Iterator<Employee> itr = al.iterator();
		Scanner sc = new Scanner(System.in);
		int flag=0;
		System.out.println("Enter the name you want to search for");
		String name = sc.nextLine();
		System.out.println("Enter id you want to search for");
		int id = sc.nextInt();
		
		while(itr.hasNext()) {
			Employee e = (Employee) itr.next();
			if(e.getName().equals(name) && e.getId()==id) {
				flag=1;
			}
		}	
			if(flag==1) {	
				System.out.println("Found");	
			}
			else
				System.out.println("Not Found");
				
		
	}
}
	
	


