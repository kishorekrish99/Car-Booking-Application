package com.Vmedico.DAO;

import javax.transaction.Transactional;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.query.Query;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.Rental;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public void bookregistration(Rental therental) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(therental);	
	}

	@Override
	@Transactional
	public Object updateactivestatus(int id) {
		Session session=sessionFactory.getCurrentSession();
		Rental therental=session.get(Rental.class,id);
		therental.setActive(false);
		session.update(therental);
		return null;
	}
	
}
