package com.xworkz.userdata.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public String onSave(UserDTO userDTO, Model model,@RequestParam("file")MultipartFile file) throws Throwable {
		System.out.println("manoj is checking");
		byte[] bytes = file.getBytes();
		System.out.println("manoj is checking    byte admele");
		
		String saveFile=System.currentTimeMillis()+" "+file.getName();// + " " + file.getOriginalFilename();//C:\Users\admin\Desktop\MANOJ
		System.out.println("manoj is checking string admele");
		System.out.println(file.getName());
		System.out.println(saveFile);
	//	Path path = Paths.get("C://Users//admin//Desktop//nandan/" + fineName);
		 

		Path path = Paths.get("C://Users//admin//Desktop//MANOJ/"+saveFile);//
		System.out.println("manoj is checking path admele");
		Files.write(path, bytes);
		System.out.println("manoj is checking wright admele");
		System.out.println(path);
		System.out.println(saveFile);
		System.out.println(file.getOriginalFilename());
		userDTO.setFileName(saveFile);
		System.out.println("Calling onSave method konedu");
		System.out.println(userDTO);

		if (userDTO != null) {
			Boolean findByEmail = userService.getByEmail(userDTO.getEmail());
			if (!findByEmail) {
				model.addAttribute("mesg", "Email already Exist,So unable to Save");

			} else {

				Boolean validateAndSave = userService.validateAndSave(userDTO);
				System.out.println(validateAndSave);
				if (validateAndSave) {
					// model.addAttribute("DTO", userDTO);
					model.addAttribute("mesg", "Data added succesfully");
				} else {
					model.addAttribute("mesg", "Not Valid");
				}
			}
		}
		return "SignUp";
	}
}