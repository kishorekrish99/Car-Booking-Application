package com.Vmedico.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.users;

@Repository
public class VehicleDAOImpl implements VehicleDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	@Transactional
	public List<Cars> getcars() {
		Session session=sessionFactory.getCurrentSession();
		Query<Cars> query=session.createQuery("from Cars",Cars.class);
		List<Cars> cars=query.getResultList();
		return cars;
	}


	@Override
	@Transactional
	public void saveCars(Cars theCars) {
		Session session=sessionFactory.getCurrentSession();
		session.saveOrUpdate(theCars);
		
	}


	@Override
	@Transactional
	public Cars getCarDetails(int id) {
		Session session=sessionFactory.getCurrentSession();
		Cars thecar=session.get(Cars.class,id);
		return thecar;
	}


	@Override
	@Transactional
	public void deleteCar(int id) {
		Session session=sessionFactory.getCurrentSession();
		Query thequery=session.createQuery("delete from Cars where id=:Vehicleid");
		thequery.setParameter("Vehicleid",id);
		thequery.executeUpdate();
		
	}


	@Override
	@Transactional
	public List<users> getUsers() {
		Session session=sessionFactory.getCurrentSession();
		Query<users> query=session.createQuery("from users",users.class);
		List<users> users=query.getResultList();
		return users;
	}

}
