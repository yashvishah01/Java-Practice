package com.example.model;

import java.time.LocalDateTime;

public class Txn {
	private int id;
	private double amount;
	private double closingbalance;
	private LocalDateTime date;
	private TxnType type;
	
	private Account account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getClosingbalance() {
		return closingbalance;
	}

	public void setClosingbalance(double closingbalance) {
		this.closingbalance = closingbalance;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public TxnType getType() {
		return type;
	}

	public void setType(TxnType type) {
		this.type = type;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
}
