package com.xworkz.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

import net.bytebuddy.matcher.ModifierMatcher.Mode;

@Controller
@RequestMapping("/edit")
public class EditController {
	
	
	@Autowired
	private UserService service;
	
	

	public EditController() {
		System.out.println("Edit controller is running");
		
		
	}
	@GetMapping
	String updateDetails(Model model, UserDTO userDTO) {
		
		UserDTO byEmail = service.getByEmail(userDTO.getEmail());
		System.out.println(byEmail);
	if (byEmail!=null) {
		model.addAttribute("msg",byEmail );
		
		return "EditDetails";
		
	}
		return" home";
		
	}
	

}
