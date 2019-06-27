package com.example;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.model.EmpSummary;
import com.example.model.Employee;



public class JPQL {
	
	
	public static void main(String [] args) {
			
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
//		String jpql = "from Employee";	// table name = employees_temp but JQPL always uses entity name ie class attr
//		Query query = em.createQuery(jpql);
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);
//		
		
//		String jpql = "from Employee";
//		Query query = em.createQuery(jpql);
//		query.setFirstResult(5);
//		query.setMaxResults(5);
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);

		// A- positional parameters
//		String jpql = "from Employee where name=?1";
//		Query query = em.createQuery(jpql);
//		String namePara = "EMP-1";
//		query.setParameter(1, namePara);
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);
		
		
		// B- named parameters
//		String jpql = "from Employee e where e.name=:empName";
//		Query query = em.createQuery(jpql);
//		String nameParam = "EMP-1";
//		query.setParameter("empName", nameParam);
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);
		
		//IT dept employees
//		String jpql= "from Employee e where e.department.name=:depName";
//		Query query = em.createQuery(jpql);
//		query.setParameter("depName", "IT");
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);
//		
		
		//*********************************************************************************
		
//		String jpql = "select e.name,e.salary from Employee e";
//		Query query = em.createQuery(jpql);
//		List<Object[]> employees = query.getResultList();
//		employees.forEach(oa->System.out.println(oa[0]+"\t"+oa[1]));

		// --------------------------------------------------------

//		String jpql = "select new list(e.name,e.salary) from Employee e";
//		String jpql = "select new map(e.name,e.salary) from Employee e";
//		String jpql = "select new com.example.model.EmpSummary(e.id,e.name) from Employee e";
//		Query query = em.createQuery(jpql);
//		List<EmpSummary> employees = query.getResultList();
//		employees.forEach(e->System.out.println(e));

		// --------------------------------------------------------

		//named query
//		Query query = em.createNamedQuery("findAll");
//		List<Employee> employees = query.getResultList();
//		employees.forEach(System.out::println);
		
		//native query
		Query query = em.createNamedQuery("getAll");
		List<Employee> employees = query.getResultList();
		employees.forEach(e->System.out.println(e));
		
		em.getTransaction().commit();
		em.close();
		emf.close();
		

	}
	
	
	
}
