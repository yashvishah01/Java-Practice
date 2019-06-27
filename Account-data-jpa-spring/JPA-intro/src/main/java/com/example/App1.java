package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.Address;
import com.example.model.Employee;
import com.example.model.Gender;



public class App1 {
	
	
	public static void main(String [] args) {
		Employee employee = new Employee();
		employee.setId(1);
		employee.setName("Alice");
		employee.setSalary(10000);
		employee.setGender(Gender.FEMALE);
		employee.setDob(LocalDate.now());
		employee.setJoinDate(LocalDateTime.now());
		
		Address address = new Address();
		address.setCity("bang");
		address.setStreet("beml");
		address.setCountry("india");
		
		Address offaddress = new Address();
		offaddress.setCity("mum");
		offaddress.setStreet("dtl");
		offaddress.setCountry("india");
		employee.getAddresses().add(address);
		employee.getAddresses().add(offaddress);
//		employee.setAddress(address);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(employee);
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
	}
	
	
	
}
