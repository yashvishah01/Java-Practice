package com.example;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.example.model.Employee;
import com.example.model.Gender;



public class App1 {
	
	
	public static void main(String [] args) {
		Employee employee = new Employee();
		
		// create
		
		employee.setId(2);
		employee.setName("bob");
		employee.setSalary(20000);
		employee.setGender(Gender.MALE);
		employee.setDob(LocalDate.now());
		employee.setJoinDate(LocalDateTime.now());
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		em.persist(employee);
//		employee.setGender(Gender.MALE);	// works bcz its in managed state 
		
		
		//retrieve
//		employee = em.find(Employee.class, 1);
//		System.out.println(employee);
		
		
		//delete
//		employee = em.find(Employee.class, 1);
//		em.remove(employee); // New
//
//		em.getTransaction().rollback();
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		
//		employee = em.find(Employee.class, 1);
//		// if no selection then it will add new row with name and other col as null
//		
//		employee.setName("alia");
//		
//		EntityManagerFactory emf2 = Persistence.createEntityManagerFactory("myPU");
//
//		em = emf2.createEntityManager();
//		em.getTransaction().begin();
//		em.merge(employee); // Managed
//		
//	
//		em.getTransaction().commit();
//		em.close();
//		emf2.close();
	}
	
	
	
}
