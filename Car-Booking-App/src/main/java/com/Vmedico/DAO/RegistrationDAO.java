package com.Vmedico.DAO;

import com.Vmedico.Model.Rental;

public interface RegistrationDAO {

	public void bookregistration(Rental therental);

	public Object updateactivestatus(int id);

}
