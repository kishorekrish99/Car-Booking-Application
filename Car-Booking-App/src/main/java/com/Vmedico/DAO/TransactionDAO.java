package com.Vmedico.DAO;

import java.util.List;

import com.Vmedico.Model.Rental;

public interface TransactionDAO {

	public List<Rental> getAllTransactions();

	public Rental getTransaction(int id);

}
