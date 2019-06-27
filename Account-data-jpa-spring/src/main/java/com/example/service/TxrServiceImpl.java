package com.example.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.model.Txn;
import com.example.model.TxnType;
import com.example.repository.AccountRepository;
import com.example.repository.TxnRepository;

public class TxrServiceImpl implements TxrService {
	private static final Logger LOGGER = Logger.getLogger("App");

	private AccountRepository accountRepository;
	
	@Autowired
	private TxnRepository txnRepository;
	

	public TxrServiceImpl() {
		LOGGER.info("TxrServiceImpl created");
	}

//	public TxrServiceImpl(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//		LOGGER.info("NEFTTxrService created with accountRepository");
//	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl got injection with accountRepository");
	}
	
	@Transactional(transactionManager = "transactionManager", 
					noRollbackFor = { RuntimeException.class }, 
			       // rollbackFor = {TxrFailedException.class },
			        timeout=60,
			        propagation=Propagation.REQUIRED,
			        isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");

		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.save(fromAccount);
//		boolean b = false;
//		if (b)
//			throw new TxrFailedException("oops");
		accountRepository.save(toAccount);

		Txn debitTxn=new Txn();
		debitTxn.setDate(LocalDateTime.now());
		debitTxn.setAmount(amount);
		debitTxn.setType(TxnType.Debit);
		debitTxn.setClosingbalance(fromAccount.getBalance());
		debitTxn.setAccount(fromAccount);
		
		Txn creditTxn=new Txn();
		creditTxn.setDate(LocalDateTime.now());
		creditTxn.setAmount(amount);
		creditTxn.setType(TxnType.Credit);
		creditTxn.setClosingbalance(toAccount.getBalance());
		creditTxn.setAccount(toAccount);
		
		
		txnRepository.save(debitTxn);
		txnRepository.save(creditTxn);
		
		
		LOGGER.info("Txr finished");
		return true;

	}

}

