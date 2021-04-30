package com.Vmedico.Service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vmedico.DAO.SignupDAO;
import com.Vmedico.Model.users;

@Service
public class SignupServiceImpl implements SignupService {
	
	@Autowired
	private SignupDAO signupdao;
	
	@Override
	@Transactional
	public void signupuser(users user) {
		signupdao.signupuser(user);
		
	}

}
