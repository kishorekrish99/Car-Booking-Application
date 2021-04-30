package com.Vmedico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Vmedico.Model.Cars;
import com.Vmedico.Model.Rental;
import com.Vmedico.Model.users;
import com.Vmedico.Service.RegistrationService;
import com.Vmedico.Service.VehicleService;

@Controller
public class RegistrationController {
	
	@Autowired
	private VehicleService vehicleservice;
	
	@Autowired
	private RegistrationService registrationservice;
	
	
	
	
	@GetMapping("/book")
	public String bookacar(@RequestParam int id,Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		Object q=authentication.getCredentials();
		//System.out.println(p.getUsername());	
		List<users> user=vehicleservice.getUsers();
		users credentials = null;
		//System.out.println(user.get(1).getUsername());
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getUsername().equals(p.getUsername())) {
				credentials=user.get(i);
				
			}
		}
		
		model.addAttribute("credentails", credentials);
		Rental rental=new Rental();
		model.addAttribute("rental", rental);		
		List<Cars> cars=vehicleservice.getcars();
		model.addAttribute("vehicle", cars);
		return "Registration";
	}
	
	
	
	@PostMapping("/bookthecar")
	public String bookthecar(@ModelAttribute("rental") Rental therental) {
		List<Cars> car=vehicleservice.getcars();
		for(int i=0;i<car.size();i++) {
			if(therental.getCarid()==car.get(i).getId()) {
				therental.setAmount(car.get(i).getPrice()) ;
				therental.setModel(car.get(i).getModel());
				car.get(i).setAvailability(false);
				vehicleservice.saveCars(car.get(i));
				
			}
		}
		therental.setActive(true);
		registrationservice.bookregistration(therental);
		
		return "redirect:/car";
	}
	
	
	
	/*@PostMapping("/bookthecar")
	public String bookthecar(@ModelAttribute("rental") Rental therental) {
		//registrationservice.bookregistration(therental);
		return "redirect:/car"; 
	}*/
}
