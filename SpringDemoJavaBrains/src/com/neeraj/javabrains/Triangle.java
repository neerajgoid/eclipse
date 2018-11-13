package com.neeraj.javabrains;

public class Triangle {

	private String rollNo;
	private int age;
	
	
	public Triangle(int age) { // constructor injection (<constructor-arg> in .xml)
	this.age = age;
}	
	

public String getRollNo() {
		return rollNo;
	}





	public void setRollNo(String rollNo) { // setter injection (<property> in .xml)
		this.rollNo = rollNo;
	}


public void draw() {
	System.out.println("Drawing triangle");
	System.out.println("Age: " + age);
	System.out.println("Roll no: "+ rollNo);
}

}
