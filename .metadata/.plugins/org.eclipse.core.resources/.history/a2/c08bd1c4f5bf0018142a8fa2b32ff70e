package com.globant.neeraj.assignments;

import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.xml.crypto.dsig.spec.HMACParameterSpec;

public class LRU {

	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int first=1;
				int last=3; // first and last value dynamiclly can depend on


		Map<Integer, Node> hm = new HashMap<>();
		
		
		
		System.out.println("Enter the numbe of pages to visit");
		int no = scanner.nextInt();
		int pg;
		for(int i=1;i<=no;i++)
		{
			System.out.println("Enter the page value");
			pg= scanner.nextInt();
			Node n = new Node();
	
		if(hm.size()<3)
		{
				n.data=pg;
			
			if(i==1)  // first element
			{
				n.next=null;
				n.prev=null;
				hm.put(i,n);
			}
			else
			{
				Node nprev=hm.get(i-1); // gets the previous node
				nprev.next= n;
				n.prev=nprev;
				n.next=null;
				hm.put(i,n);
			}	
		}
		else
		{
			n.data=pg;
			int flag=0;
			for (Node n1 : hm.values()) // check if new pgno is already in hm
			{
				if(n1.data==pg)
				{
					System.out.println("Already present");
					flag=1;
				}
				
				if(flag==1)
				{
					if(n1.prev==null)
					{
						hm.remove(first); // need to remove the 1st element
						
						first++;
						Node nodelast =hm.get(last); //get the last element in hm
						nodelast.next = n;
						n.prev = nodelast;
						n.next=null;
						last++;
						
						Node nodefirst = hm.get(first);
						nodefirst.prev=null;
						
						hm.put(last, n);
					}
					else if(n1.next==null)
					{
						
					}
					else if(n1.prev!=null && n1.next!=null)
					{
						n1.prev.next = n1.next;
						n1.next.prev = n1.prev;
						hm.values().remove(n1);
						Node nodelast =hm.get(last);
						nodelast.next = n;
						n1.prev = nodelast;
						n1.next=null;
						last++;
						hm.put(last, n);
						
					}
					break; // cause value will come only once
				}
					
			}
			if(flag==0) // new pg value being inserted
			{
				hm.remove(first); // need to remove the 1st element
				
				first++;
				Node nodelast =hm.get(last); //get the last element in hm
				nodelast.next = n;
				n.prev = nodelast;
				n.next=null;
				last++;
				hm.put(last, n);
			}
					
		}	
		
		}
		System.out.println("The final list is");
		
		for (Node n : hm.values())
		{
			System.out.println(n.data);
		}
		
		
	}
}