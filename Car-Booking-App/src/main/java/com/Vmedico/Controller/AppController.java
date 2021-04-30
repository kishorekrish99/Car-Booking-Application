package com.Vmedico.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.Vmedico.Model.users;
import com.Vmedico.Service.VehicleService;
@Controller	
public class AppController {
	@Autowired
	private VehicleService service;
	

	@GetMapping("/")
	public String showHome(Model model) {
		//SecurityContext context=SecurityContextHolder.getContext() ;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User p=(User) authentication.getPrincipal();
		Object q=authentication.getCredentials();
		//System.out.println(p.getUsername());
		
		List<users> user=service.getUsers();
		users credentials = null;
		//System.out.println(user.get(1).getUsername());
		for(int i=0;i<user.size();i++) {
			if(user.get(i).getUsername().equals(p.getUsername())) {
				credentials=user.get(i);
				
			}
		}
	
		model.addAttribute("credentails", credentials);
		
		return "home";
	}
	
}