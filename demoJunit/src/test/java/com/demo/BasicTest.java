package com.demo;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert; // ensure that this is what comes for assert and not frame
import org.junit.Before;




public class BasicTest {

	@BeforeClass
	public static void runOnceBeforeClass() {
		System.out.println("@BeforeClass - run once before class");
	}
	
	@AfterClass
	public static void runOnceAfterClass() {
		System.out.println("@AfterClass - run once after class");
	}
	
	@Before
	public  void runBeforeTestMethod() {
		System.out.println("@Before - run before every @Test method");
	}
	
	
	@After
	public  void runAfterTestMethod() {
		System.out.println("@After - run after every @Test method");
	}
	
	
	
	@Test
	public  void test1() {
		System.out.println("Running 1st Test");
		App app = new App();
		boolean result =app.isNum("1");
	//	Assert.assertNotNull(app);
	//	Assert.assertEquals(true,result );
		
		Assert.assertEquals(true, result);
		
	}
	
	@Test
	public void test2() {
		System.out.println("Runnning test 2");
		
		String obj1 = "test";
		String obj2 = "test";
		
		String obj3 = "tester";
		String obj4 = "testing";
		
		int[] arr1 = {1,2,3};
		int[] arr2 = {1,2,3};
		
		
	
		
		assertEquals("obj1 and obj2 are same",obj1, obj2); // now here I have not written Assert.assertEquals and instead assertEquals
									// works coz of 'import static org.junit.Assert.assertEquals; '
		
		assertArrayEquals("failed as aarryas as not equal ",arr1, arr2);
		
		
		
	}
	
	public void test3() {
		Calculate c = new Calculate();
		int d= c.sum(4, 3);
		
		Assert.assertEquals(7,d);
		
	}
	
}
