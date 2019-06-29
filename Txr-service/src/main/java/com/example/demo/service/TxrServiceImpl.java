package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Account;
import com.example.demo.model.Txn;
import com.example.demo.model.TxnType;
import com.example.demo.repository.AccountRepository;
import com.example.demo.repository.TxnRepository;

@Service
public class TxrServiceImpl implements TxrService {

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private TxnRepository txnRepository;
	

//	public void setAccountRepository(AccountRepository accountRepository) {
//		this.accountRepository = accountRepository;
//		}
	
	@Transactional
	@Override
	public List<Txn> show(String AccNum) {
		List<Txn> list= txnRepository.findByNum(AccNum);
		return list;
	}
	
	@Transactional(transactionManager = "transactionManager", 
					noRollbackFor = { RuntimeException.class }, 
			       // rollbackFor = {TxrFailedException.class },
			        timeout=60,
			        propagation=Propagation.REQUIRED,
			        isolation=Isolation.READ_COMMITTED)
	@Override
	public boolean transfer(double amount, String fromAccNum, String toAccNum) {

		Account fromAccount = accountRepository.findById(fromAccNum).get();
		Account toAccount = accountRepository.findById(toAccNum).get();

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
		
		
		return true;

	}

}

