package com.Vmedico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Vmedico.Model.Cars;
import com.Vmedico.Service.VehicleService;

@Controller
public class CarController {
	
	@Autowired
	private VehicleService vehicleservice;
	
	
	
	
	@GetMapping("/car")
	public String getcars(Model model) {
		List<Cars> cars=vehicleservice.getcars();
		System.out.print(cars);
		model.addAttribute("vehicle", cars);
		return "Car";
	}
	
	@GetMapping("/showFormforAdd")
	public String FormForAdd(Model model) {
		Cars thecars=new Cars();
		model.addAttribute("car", thecars);
		return "addCars";
	}
	
	@PostMapping("/saveCars")
	public String saveCars(@ModelAttribute("car") Cars theCars) {
		System.out.println("this is about to save"+theCars);
		vehicleservice.saveCars(theCars);
		return "redirect:/car";
	}
	
	@GetMapping("/showFormForUpdate")
	public String updateCars(@RequestParam("id") int id,Model model) {
		Cars thecar=vehicleservice.getCardetails(id);
		model.addAttribute("car", thecar);
		return "addCars";
	}
	
	@GetMapping("/delete")
	public String deletecar(@RequestParam("id") int id) {
		vehicleservice.deletecar(id);
		return "redirect:/car";
	}
}
