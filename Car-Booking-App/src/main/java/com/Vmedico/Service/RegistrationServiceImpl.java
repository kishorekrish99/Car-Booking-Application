package com.Vmedico.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vmedico.DAO.RegistrationDAO;
import com.Vmedico.Model.Rental;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	private RegistrationDAO registrationdao;
	
	
	@Override
	@Transactional
	public void bookregistration(Rental therental) {
		registrationdao.bookregistration(therental);
		
	}


	@Override
	@Transactional
	public void updateactivestatus(int id) {
		registrationdao.updateactivestatus(id);
		
	}
	
}
