package com.Vmedico.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.Vmedico.Model.authorities;
import com.Vmedico.Model.users;

@Repository
public class SignupDAOImpl implements SignupDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public void signupuser(users user) {
		user.setEnabled(true);
		String password="{noop}"+user.getPassword();
		user.setPassword(password);
		Session session=sessionFactory.getCurrentSession();
		authorities auth=new authorities();
		auth.setName(user.getUsername());
		auth.setAuthority("ROLE_CUSTOMER");
		authorities auth1=new authorities();
		auth1.setName(user.getUsername());
		auth1.setAuthority("ROLE_MEMBER");
		session.save(user);
		session.save(auth);
		
	}
	
}
