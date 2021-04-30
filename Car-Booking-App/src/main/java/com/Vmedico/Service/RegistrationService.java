package com.Vmedico.Service;

import com.Vmedico.Model.Rental;

public interface RegistrationService {

	public void bookregistration(Rental therental);

	public void updateactivestatus(int id);

}
