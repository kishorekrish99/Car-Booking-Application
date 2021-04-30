package com.Vmedico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Vmedico.Model.users;
import com.Vmedico.Service.VehicleService;

@Controller
public class UserController {
	@Autowired
	private VehicleService ser;
	
	@GetMapping("/users")
	public String userslist(Model model) {
		List<users> user=ser.getUsers();
		model.addAttribute("user", user);
		return "User";
	}
}
