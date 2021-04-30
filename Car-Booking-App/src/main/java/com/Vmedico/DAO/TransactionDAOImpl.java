package com.Vmedico.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.Rental;

@Repository
public class TransactionDAOImpl implements TransactionDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Rental> getAllTransactions() {
		Session session=sessionFactory.getCurrentSession();
		Query<Rental> query=session.createQuery("from Rental order by id DESC",Rental.class);
		List<Rental> rental=query.getResultList();
		return rental;
	}

	@Override
	@Transactional
	public Rental getTransaction(int id) {
		Session session=sessionFactory.getCurrentSession();
		Rental rental=session.get(Rental.class, id);
		return rental;
	}

}
