package com.Vmedico.DAO;

import java.util.List;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.users;

public interface VehicleDAO  {

	public List<Cars> getcars();

	public void saveCars(Cars theCars);

	public Cars getCarDetails(int id);

	public void deleteCar(int id);

	public List<users> getUsers();

}
