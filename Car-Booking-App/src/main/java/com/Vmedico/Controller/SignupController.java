package com.Vmedico.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Vmedico.Model.users;
import com.Vmedico.Service.SignupService;

@Controller
public class SignupController {
	
	@Autowired
	private SignupService signupservice;
	
	
	@GetMapping("/signup")
	public String signup(Model model) {
		users user=new users();
		model.addAttribute("signup", user);
		return "signup";
	}
	
	@PostMapping("/signupuser")
	public String signupuser(@ModelAttribute("signup") users user) {
		signupservice.signupuser(user);
		return "redirect:/showMyLoginPage";
	}
}
