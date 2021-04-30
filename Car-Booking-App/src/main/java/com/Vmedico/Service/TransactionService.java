package com.Vmedico.Service;

import java.util.List;

import com.Vmedico.Model.Rental;

public interface TransactionService {

	public List<Rental> getAllTransactions();

	public Rental getTransaction(int id);

}
