package com.xworkz.userdata.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	Integer count = 0;
	@Autowired
	private UserService userService;
 
	@PostMapping
	public String signIn(Model model, UserDTO userDTO) {
		
		return onRequest(model, userDTO);
	}
	
	@GetMapping
	public String onRequest(Model model, UserDTO userDTO) {

		System.out.println("Calling SignIn Method");
		List<UserDTO> findByEmailAndPassword = userService.findByEmailAndPassword(userDTO.getEmail(),
				userDTO.getSecurity(), userDTO);
		System.out.println(findByEmailAndPassword);

		if (findByEmailAndPassword == null) {
			model.addAttribute("Msg", "Incorrect credentials Entered");
			count++;
			if(count == 3) {
				model.addAttribute("Msg","Your Account has Been Blocked");
			}
		} else {
			if (findByEmailAndPassword.get(0).getStatus().equals("Blocked")) {
				model.addAttribute("Msg", "your Account Has Been Locked");

			} else {
				System.out.println("Welcome To Home Page!");
				model.addAttribute("Msg", userDTO.getUsername() + "WelCome to your profile");
				return "home";
			}
			
		}
		return "SignIn";
	}
}