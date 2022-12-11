package com.xworkz.userdata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Controller
@RequestMapping("reset")
public class ResetPasswordController {

	@Autowired
	private UserService userServivce;

	@GetMapping
	public String generateOTP(UserDTO userDTO, Model model) {
		System.out.println(userDTO.getOtp()+"+++++++++++++++++++++++++++++++++++++++++++++++-------------------------------------");

		Boolean updateOTPByEmail = userServivce.updateOtpByEmail(userDTO.getEmail(),
		 userDTO);
		
		if (updateOTPByEmail) {
			return "ConfirmPassword";
		} else {
			return "ForgotPassword";
		}

	}

	@PostMapping("otp")
	public String UpdatePasswordAndStatus(UserDTO userDTO, Model model) {
	
		
		if (userDTO.getSecurity().equals(userDTO.getReSecurity())) {
			Boolean resetPassword = userServivce.resetPasswordByEmail(userDTO.getEmail(), userDTO.getSecurity(),
					userDTO.getOtp(), userDTO, userDTO.getReSecurity());
			
			if (resetPassword) {
				model.addAttribute("Msg", "Password Updated");
				return "SignIn";
			} else {
				model.addAttribute("Msg", "Unable To Update Password");
				return "ConfirmPassword";
			}
		} else {

			model.addAttribute("msg", "you passward doesnot match");
			return "ConfirmPassword";
		}

	}

}