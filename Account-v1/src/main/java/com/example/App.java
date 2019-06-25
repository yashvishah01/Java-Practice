package com.example;

import org.apache.log4j.Logger;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.service.TxrService;

public class App {
	private static final Logger LOGGER = Logger.getLogger("App");

	public static void main(String[] args) {

		// -------------------------------------
		// init / boot
		// -------------------------------------
		ConfigurableApplicationContext context = null;
		context = new ClassPathXmlApplicationContext("account-service.xml");

		LOGGER.info("app init/booted..");
		System.out.println();
		// -------------------------------------
		// use
		// -------------------------------------
		LOGGER.info("app in use");
		TxrService txrService = context.getBean("txrService", TxrService.class);
		txrService.transfer(5500.00, "2", "1");
		System.out.println();

		System.out.println();
		// -------------------------------------
		// destroy
		// -------------------------------------
		LOGGER.info("app destroyed");
		context.close();
		// -------------------------------------
	}
}
