
package com.xworkz.userdata.service;

import java.util.*;

import com.xworkz.userdata.dto.ProductDTO;
import com.xworkz.userdata.dto.UserDTO;

public interface UserService {

	public Boolean validateAndSave(UserDTO userDTO);

	public UserDTO getByEmail(String email);

	public Boolean sendEmail(String email, String password, UserDTO userDTO);

	public UserDTO findByEmailAndPassword(String email, String password, UserDTO userDTO);

	public String password();

	public void updateCountByEmail(Integer count, String email);

	public void updateStatus(String email, String status);

	default Boolean updatePasswordByEmail(String security, String email) {
		return null;
	}

	default Integer otpGeneration() {
		return null;
	}

	default Boolean updateOtpByEmail(String email, UserDTO userDTO) {
		return null;
	}

	default Boolean resetPasswordByEmail(String email, String security, Integer otp, UserDTO userDTO,
			String reSecurity) {
		return null;
	}

	default Boolean sendOTPMail(String otpMail, Integer otp, UserDTO userDTO) {
		return true;

	}

	default Boolean UpdateUserDetailsByEmail(String name, String phoneno, String email, String fileName) {
		return true;
	}

	default String EncryptedPassword() {
		return null;

	}

	default String EncryptPassword(String security) {
		return null;

	}

	default String DecryptedPassword(String encryptsecurity) {
		return null;

	}

	

}
