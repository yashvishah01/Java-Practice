package com.example.demo.model;

import java.time.LocalDateTime;

//import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name="TXN")
public class Txn {
	@Id
	@SequenceGenerator(name="seq", sequenceName = "Txn_seq",allocationSize=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq")
	private int id;
	private double amount;
	
	private double closingbalance;
	@Column(name="time")
	private LocalDateTime date;
	@Enumerated(EnumType.STRING)
	private TxnType type;
	
	@ManyToOne
	@JoinColumn(name="ac_num")
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
