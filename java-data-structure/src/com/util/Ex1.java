package com.util;

import com.util.LinkedList;

public class Ex1 {

	public static void main(String [] args) {
		LinkedList<String> ll = new LinkedList<>();
		
		ll.add("bread");
		ll.add("butter");
		ll.add("cheese");
		ll.add("cake");
		
		//ll.iterator();
		
//		System.out.println();
//		
//		ll.add(2, "ice");
//		ll.iterator();
//		
//		System.out.println();
//		ll.add(3, "cube");
//		ll.iterator();
//		
//		System.out.println();
//		ll.set(3, "biscuit");
//		ll.iterator();
//		
//		System.out.println();
//		ll.remove(2);
//		ll.iterator();
//		
//		System.out.println();
//		String s = ll.get(2);
//		System.out.println(s);
//		
//		System.out.println();
//		ll.remove("cake");
//		ll.iterator();
////		System.out.println();
////		ll.remove("cheese");
////		ll.iterator();
//		
		ll.add("choco");
		ll.iterator();
		System.out.println();
//		ll.reverse();
//		ll.iterator();
		
		ll.set(8, "yyy");
		ll.iterator();
		System.out.println();
		
	}
}
