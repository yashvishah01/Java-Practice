package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, String>{

//	Account load(String accNum);
//
//	Account update(Account account);
//	
//	default void save(Txn txn) {
//	}
	
	@Query("from Account acc where acc.balance=?1")
	List<Account> findByAmount(double balance);
	
}
