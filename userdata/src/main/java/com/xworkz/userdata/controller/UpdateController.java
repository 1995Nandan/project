package com.xworkz.userdata.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	String update(UserDTO dto,@RequestParam("file")MultipartFile file) throws IOException {
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

		
	Boolean updatePhoneNoAndNameByEmail = dao.updatePhoneNoAndNameByEmail(dto.getPhoneno(), dto.getUsername(),dto.getEmail(),dto.getFileName());
	System.out.println(updatePhoneNoAndNameByEmail);
		return "SignIn";
		
	}

	

}
