package com.neeraj.javabrains;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ApplicationContext ap = new ClassPathXmlApplicationContext("spring.xml");
		// ApplicationContext is the superset of BeanFactory. It needs to read config from some file 
		// that file name is specified in the round brackets
		Triangle tri = (Triangle) ap.getBean("tri123");
		//Need to always typecast an object.
		//ap.getBean creates an object of the class specified as the 'class' parameter in the config file
		//(ie the xml file) where the id of the bean is "tri123"
		//since it creates an object of type triangle 
		
		tri.draw();
		
	}

}
