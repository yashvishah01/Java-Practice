package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.repository.AccountRepository;
import com.example.service.TxrService;
import com.example.service.TxrServiceImpl;

@EnableTransactionManagement
//@EnableAspectJAutoProxy
@Configuration
@Import(value = { DataSourceConfiguration.class,TransactionManagerConfiguration.class })
@ComponentScan(value = {"com.example.repository","com.example.service"/*,"com.example.aspects"*/})
public class AccountServiceConfiguration {
	@Autowired
	@Qualifier("jdbc")
	private AccountRepository accountRepository;

	@Bean("txrService")
	public TxrService txrService() {
		TxrServiceImpl txrService = new TxrServiceImpl();
		txrService.setTxrType("IMPS");
		txrService.setAccountRepository(accountRepository);
		return txrService;
	}
}
