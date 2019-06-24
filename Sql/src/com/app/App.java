package com.app;

import java.util.Optional;

import com.app.model.Product;
import com.app.model.productType;
import com.app.repository.JdbcProductRepository;
import com.app.repository.ProductRepository;

public class App {
	
	public static void main(String[] args) {

		ProductRepository productRepository = new JdbcProductRepository();

//		Product product = new Product(2,"Mobile", 198000.00, productType.ELEC);
//
//		productRepository.save(product);
//		
		Optional<Product> product1=productRepository.findById(1);
		System.out.println(product1);
	}
}
