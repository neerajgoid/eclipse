package com.globant.neeraj.assignments;

public class Employee implements Comparable<Employee>{

	private String name;
	private int id;
	private int age;
	
	public Employee(String name,int id,int age)	{
		this.name= name;
		this.age=age;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Employee e) {
	
		if(this.getAge()>e.getAge())
		{
			return -1;
		}
		else if(this.getAge()< e.getAge())
		{
			return +1;
		}
		else
		return 0;
	}
	
	
	
/*	public void display(Employee) {
		
		
	}
*/	
	
	
	
}
