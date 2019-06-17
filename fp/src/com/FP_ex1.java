package com;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.lib.lib;


public class FP_ex1 {

	static List<Product> products = new ArrayList<>();

	static {
		products.add(new Product(321434, "item-1", 1000.00));
		products.add(new Product(421431, "item-2", 3000.00));
		products.add(new Product(221433, "item-3", 7000.00));
		products.add(new Product(621437, "item-4", 1000.00));
		products.add(new Product(821436, "item-5", 5000.00));

	}
	
//	private static List<Product> getProducts(double price) {
//		class ByPrice implements Predicate<Product>{
//			@Override
//			public boolean test(Product t) {
//				return t.getPrice() == price;
//			}
//		}
//		
//		Predicate<Product> byprice = new ByPrice();
//		return lib.filter(products,byprice);
//		
//	}
	
//	private static List<Product> getProducts(double price) {
//		Predicate<Product> byprice = new Predicate<Product>(){
//			@Override
//			public boolean test(Product t) {
//				return t.getPrice() == price;
//			}
//		};
//		
//		return lib.filter(products,byprice);
//		
//	}
	
	private static List<Product> getProducts(double price) {
//	Predicate<Product> byprice = new Predicate<Product>(){
//		@Override
//		public boolean test(Product t) {
//			return t.getPrice() == price;
//		}
//	};
	
	return lib.filter(products,t->t.getPrice()==price);
	
}
	
	
	private static void display(List<Product> products) {
		for (Product product : products)
			System.out.println(product);
	}
	
	
	
		public static void main(String args[]) {
//			List<String> menu = new ArrayList<>();
//			menu.add("nveg");
//			menu.add("nveg");
//			menu.add("veg");
//			menu.add("nveg");
//			menu.add("veg");
//			menu.add("veg");
//			menu.add("nveg");
//			
//			List<String> menu_veg = new ArrayList<>();
//			for(String l: menu) {
//				if(l.equals("veg"))
//					menu_veg.add(l);
//			}
			
			
			
			products = getProducts(1000.00);
			//products = getProducts(1000.00, 3000.00);
			display(products);
			
		}

		
		
		
}
