package com.example.service;

import java.util.List;

import com.example.model.Txn;

public interface TxrService {

	boolean transfer(double amount, String fromAccNum, String toAccNum);
	public List<Txn> show(String AccNum) ;
}
