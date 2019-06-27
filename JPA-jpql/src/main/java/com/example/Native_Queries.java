package com.example;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.Employee;

public class Native_Queries {

	public static void main(String [] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		
//		Query query = em.createNamedQuery("getAll");
//		List<Employee> employees = query.getResultList();
//		employees.forEach(e->System.out.println(e));
		
		
		//strem
		em.createNamedQuery("getAll")
			.getResultList()
			.forEach(e->System.out.println(e));
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}

	private static void getResultList() {
		// TODO Auto-generated method stub
		
	}
}
