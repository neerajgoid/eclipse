package com.globant.neeraj.assignments;

import java.util.Scanner;
import java.util.Stack;

public class Parenthesis {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter your string(in parenthesis form)");
		String input = scanner.next();
		Stack<Character> stack = new Stack<>();
		check(stack, input);
	}
	

	public static void check(Stack<Character> stack,String input) {
		
		char c0;
		int flag=0;
		for(int itr=0;itr<input.length();itr++) {
			c0 = input.charAt(itr);
		
			if(c0=='{'||c0=='['||c0=='(')
			{
				stack.push(c0);
			}
			else if(stack.isEmpty())
			{
				if(c0=='}'||c0==']'||c0==')')
				//System.out.println("Not perfect");
				flag=1;	
				break;
			}
				else if(c0=='}' && stack.pop()=='{')
			{
				//System.out.println("match found");
			}
			else if(c0==']' && stack.pop()=='[')
			{
			//	System.out.println("match found");
			}
			else if(c0==')' && stack.pop()=='(') {
				//System.out.println("match found");
			}
			else {
			//	System.out.println("Not perfect");
				break;
			}
				
		}
		
		if(stack.empty() && flag==0)
		{
			System.out.println("Perfect ");
		}
		else
		{
			System.out.println("Not Perfect");
			System.exit(0);
		}	
		
		
	}

	}
	
	
	
	


