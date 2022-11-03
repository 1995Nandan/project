package com.xworkz.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public String onSave(UserDTO userDTO, Model model) {
		System.out.println("Calling onSave method");
		System.out.println(userDTO);
		
		if (userDTO != null) {
			Boolean findByEmail = userService.getByEmail(userDTO.getEmail());
			if (!findByEmail) {
				model.addAttribute("mesg", "Email already Exist,So unable to Save");

			} else {

				Boolean validateAndSave = userService.validateAndSave(userDTO);
				System.out.println(validateAndSave);
				if (validateAndSave) {
					model.addAttribute("DTO", userDTO);
					model.addAttribute("mesg", "Data added succesfully");
				} else {
					model.addAttribute("mesg", "Not Valid");
				}
			}
	}
		return "SignUp";

}
}