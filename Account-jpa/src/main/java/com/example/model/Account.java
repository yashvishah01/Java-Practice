package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ACCOUNTS")
public class Account {
	
	@Id
	@Column(name="num")
	private String number;
	
	private double balance;
	
	public Account() {
		
	}
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [number=" + number + ", balance=" + balance + "]";
	}
	public Account(String number) {
		super();
		this.number = number;
	}
	


}
