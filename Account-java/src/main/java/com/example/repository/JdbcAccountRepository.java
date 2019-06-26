package com.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
import com.example.model.Txn;

@Repository("jdbcAccountRepository")
@Qualifier("jdbc")
public class JdbcAccountRepository implements AccountRepository {

	private static final Logger LOGGER = Logger.getLogger("App");	// use for log file

	//private DataSource dataSource;	//use for connection dbcp

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcAccountRepository(DataSource dataSource) {
		//this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		LOGGER.info("JdbcAccountRepository created with datasource");
	}


	public Account load(String accNum) {
		LOGGER.info("loading account : " + accNum);
		Account account = new Account();
		
		String sql = "select * from ACCOUNTS where num=?";
		jdbcTemplate.queryForObject(sql, (rs, rowNum) -> {
			account.setNumber(rs.getString("num"));
			account.setBalance(rs.getDouble("balance"));
			return account;
		}, accNum);
		return account;
//		try {
//			Connection con = dataSource.getConnection();
//			String sql = "select * from ACCOUNTS where num=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, accNum);
//
//			ResultSet rs = ps.executeQuery();
//			if (rs.next()) {
//				account.setNumber(rs.getString("num"));
//				account.setBalance(rs.getDouble("balance"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return account;
	}


	public Account update(Account account) {
		//
		LOGGER.info("updating account : " + account.getNumber());

		String sql = "update ACCOUNTS set balance=? where num=?";
		int rowCount = jdbcTemplate.update(sql, account.getBalance(), account.getNumber());
		return account;
		
//		try {
//			Connection con = dataSource.getConnection();
//			String sql = "update ACCOUNTS set balance=? where num=?";
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setDouble(1, account.getBalance());
//			ps.setString(2, account.getNumber());
//
//			ps.executeUpdate();
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return account;
	}

	
	public void save(Txn txn) {
		//
		LOGGER.info("updating account : ");

		String sql = "insert into Txn (id,time,amount,type,closingBalance,ac_num) values (Txn_seq.nextval,?,?,?,?,?)";
		jdbcTemplate.update(sql,Timestamp.valueOf(txn.getDate()),txn.getAmount(),txn.getType().name(),txn.getClosingbalance(),txn.getAccount().getNumber() );
		
		
	}


}