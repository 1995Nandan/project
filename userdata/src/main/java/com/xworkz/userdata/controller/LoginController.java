package com.xworkz.userdata.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.nio.file.Files;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
		UserDTO findByEmailAndPassword = (UserDTO) userService.findByEmailAndPassword(userDTO.getEmail(),
				userDTO.getSecurity(), userDTO);
		System.out.println(findByEmailAndPassword);

		if (findByEmailAndPassword == null) {
			model.addAttribute("Msg", "Password Wrong");
			count++;
			if (count == 3) {
				model.addAttribute("Msg", "Your Account has Been Blocked");
			}
		} else {
			if (findByEmailAndPassword.getStatus().equals("Blocked")) {
				model.addAttribute("Msg", "your Account Has Been Locked");

			} else {
				System.out.println("Welcome To Home Page!");
				model.addAttribute("Msg", userDTO.getUsername() + "WelCome to your profile");
				model.addAttribute("UserDTO", findByEmailAndPassword);
				return "home";
			}

		}
		return "SignIn";
	}
@GetMapping(value = {"/image","/login/image"})
	void sendfile(@RequestParam String fileName, HttpServletResponse response) throws IOException {
		File file = new File("C://Users//admin//Desktop//MANOJ/" + fileName);
		String fromName = URLConnection.guessContentTypeFromName(file.getName());
		response.setContentType(fromName);
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			outputStream.write(Files.readAllBytes(file.toPath()));

		}
	}
}