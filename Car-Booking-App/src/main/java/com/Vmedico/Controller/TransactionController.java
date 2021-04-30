package com.Vmedico.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.Rental;
import com.Vmedico.Service.RegistrationService;
import com.Vmedico.Service.TransactionService;
import com.Vmedico.Service.VehicleService;

@Controller
public class TransactionController {
		
		@Autowired
		private RegistrationService registrationservice;
		
		@Autowired
		private TransactionService transactionservice;
		
		@Autowired
		private VehicleService vehicleservice;
		
	@GetMapping("/usertransaction")
	public String getusertransactions(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		List<Rental> rental=transactionservice.getAllTransactions();
		List<Rental> list=new ArrayList<Rental>();
		for(int i=0;i<rental.size();i++) {
			if(p.getName().equals(rental.get(i).getUsername())) {
				
				list.add(rental.get(i));
				
			}
		}
		
		model.addAttribute("rental", list);
		
		return "usertransaction";
	}
	
	@GetMapping("/currenttransaction")
	public String currenttransactions(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		List<Rental> rental=transactionservice.getAllTransactions();
		List<Rental> list=new ArrayList<Rental>();
		for(int i=0;i<rental.size();i++) {
			if(p.getName().equals(rental.get(i).getUsername()) && rental.get(i).isActive()==true) {
				
				list.add(rental.get(i));
				
			}
		}
		model.addAttribute("rental", list);
		
		return "currenttransaction";
	}
	@GetMapping("/return")
	public String returning(@RequestParam("id") int id,Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		List<Rental> rental=transactionservice.getAllTransactions();
		List<Rental> list=new ArrayList<Rental>();
		for(int i=0;i<rental.size();i++) {
			if(p.getName().equals(rental.get(i).getUsername()) && rental.get(i).isActive()==true) {
				
				list.add(rental.get(i));
				
			}
		}
		model.addAttribute("rental", list);
		registrationservice.updateactivestatus(id);
		List<Cars> cars=vehicleservice.getcars();
		System.out.println(cars);
		Rental transaction=transactionservice.getTransaction(id);
		System.out.println("transaction is            "+transaction);
		for(int i=0;i<cars.size();i++) {
			if(cars.get(i).getId()==transaction.getId()) {
				cars.get(i).setAvailability(true);
				System.out.println(cars.get(i));
				vehicleservice.saveCars(cars.get(i));
			}
		}
		return "usertransaction";
	}
}
