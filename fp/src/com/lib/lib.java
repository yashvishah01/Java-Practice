package com.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.Product;

public class lib {

		public static List<Product> filter(List<Product> inp, Predicate<Product> predicate){
			List<com.Product> out = new ArrayList<>();
				for(Product product: inp) {
					if(predicate.test(product))
						out.add(product);
				}
				return out;
		}
}
