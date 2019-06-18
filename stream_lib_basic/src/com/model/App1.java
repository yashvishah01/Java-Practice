package com.model;

import java.util.Arrays;
import java.util.List;

public class App1 {

		public static void main(String[] args) {
			List<Product> Products = Arrays.asList(
					new Product(1,"item-1",1000.00),
					new Product(2,"item-2",2000.00),
					new Product(3,"item-3",3000.00),
					new Product(4,"item-4",4000.00),
					new Product(5,"item-5",5000.00),
					new Product(6,"item-6",6000.00),
					new Product(7,"item-7",7000.00)
					);
			
			Products
			.stream()
			.filter(e->e.getPrice()>5000)
			.map( e->e.getName())
			.forEach(System.out::println);
			
			System.out.println();
			List<Product> r1 = lib.filter(Products, e->e.getPrice()>5000);
			List<String> r2 = lib.map(r1, e->e.getName());
			lib.forEach(r2, System.out::println);
			
			System.out.println();
			List<Product> r3 = lib.filter(Products, e->e.getPrice()<5000);
			List<String> r4 = lib.map(r3, e->e.getName());
			lib.forEach(r4, System.out::println);
			
			System.out.println();
			List<Product> r5 = lib.filter(Products, e->e.getName().equals("item-1"));
			List<Integer> r6 = lib.map(r5, e->e.getId());
			lib.forEach(r6, System.out::println);
		}
	
		
		
}
