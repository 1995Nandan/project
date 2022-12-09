package com.xworkz.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.userdata.dao.UserDAO;
import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Controller
@RequestMapping("/edit")
public class UpdateController {
	
	@Autowired
	private UserDAO dao;
	
	public UpdateController() {
		System.out.println("update controller is running");
		
	}
	
	@PostMapping
	String update(UserDTO dto) {
		
	Boolean updatePhoneNoAndNameByEmail = dao.updatePhoneNoAndNameByEmail(dto.getPhoneno(), dto.getUsername(),dto.getEmail());
	System.out.println(updatePhoneNoAndNameByEmail);
		return "SignIn";
		
	}

	

}
