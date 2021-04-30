package com.Vmedico.Service;

import java.util.List;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.users;

public interface VehicleService {

	public List<Cars> getcars();

	public void saveCars(Cars theCars);

	public Cars getCardetails(int id);

	public void deletecar(int id);

	public List<users> getUsers();

}
