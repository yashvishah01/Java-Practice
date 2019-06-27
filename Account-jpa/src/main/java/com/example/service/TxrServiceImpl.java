package com.example.service;

import java.time.LocalDateTime;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;

import com.example.model.Account;
import com.example.model.Txn;
import com.example.model.TxnType;
import com.example.repository.AccountRepository;

public class TxrServiceImpl implements TxrService {
	private static final Logger LOGGER = Logger.getLogger("App");

	private AccountRepository accountRepository;
	
	private String txrType = "NEFT";

	public String getTxrType() {
		return txrType;
	}

	public void setTxrType(String txrType) {
		this.txrType = txrType;
	}

//	public TxrServiceImpl(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//		LOGGER.info("NEFTTxrService created with accountRepository");
//	}

	public void setAccountRepository(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		LOGGER.info("TxrServiceImpl got injection with accountRepository");
	}
	
	@PostConstruct
	public void init() {
		LOGGER.info("TxrService :: init()");
		if (txrType.isEmpty())
			this.txrType = "NEFT";
	}
	
	@Transactional
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {
		LOGGER.info("Txr initiated");

		Account fromAccount = accountRepository.load(fromAccNum);
		Account toAccount = accountRepository.load(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance()-amount);
		toAccount.setBalance(toAccount.getBalance()+amount);
		
		accountRepository.update(fromAccount);
		accountRepository.update(toAccount);

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
		
		
		accountRepository.save(debitTxn);
		accountRepository.save(creditTxn);
		
		
		LOGGER.info("Txr finished");
		return true;

	}

}

