package com.Vmedico.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vmedico.DAO.TransactionDAO;
import com.Vmedico.Model.Rental;

@Service
public class TransactionSericeImpl implements TransactionService {
	
	@Autowired
	public TransactionDAO transactiondao;
	
	@Override
	@Transactional
	public List<Rental> getAllTransactions() {
		return transactiondao.getAllTransactions();
	}

	@Override
	@Transactional
	public Rental getTransaction(int id) {
		return transactiondao.getTransaction(id);
	}

}
