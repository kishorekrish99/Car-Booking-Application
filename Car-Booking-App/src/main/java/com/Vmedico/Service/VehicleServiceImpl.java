package com.Vmedico.Service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vmedico.DAO.VehicleDAO;
import com.Vmedico.Model.Cars;
import com.Vmedico.Model.users;

@Service
public class VehicleServiceImpl implements VehicleService {
	
	
	@Autowired
	private VehicleDAO vehicledao;
	
	@Override
	@Transactional
	public List<Cars> getcars() {
		return vehicledao.getcars();
	}

	@Override
	@Transactional
	public void saveCars(Cars theCars) {
		vehicledao.saveCars(theCars);
	}

	@Override
	@Transactional
	public Cars getCardetails(int id) {
		return vehicledao.getCarDetails(id);
	}

	@Override
	@Transactional
	public void deletecar(int id) {
		vehicledao.deleteCar(id);
	}

	@Override
	@Transactional
	public List<users> getUsers() {
		return vehicledao.getUsers();
	}

}
