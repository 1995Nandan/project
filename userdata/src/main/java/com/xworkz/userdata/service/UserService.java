
package com.xworkz.userdata.service;

import java.util.*;

import com.xworkz.userdata.dto.UserDTO;

public interface UserService {

	public Boolean validateAndSave(UserDTO userDTO);
	
	public Boolean getByEmail(String email);
	
	public Boolean sendEmail(String email,String password,UserDTO userDTO);
	
	public List<UserDTO>findByEmailAndPassword(String email,String password,UserDTO userDTO);
	
	public String password();
	
	public void updateCountByEmail(Integer count,String email);
	
	public void updateStatus(String email,String status);
	
	 default	Boolean updatePasswordByEmail(String security,String email) {
			return null;
		}
		
		 default	Integer otpGeneration() {
			return null;
		}
		
		 default	Boolean updateOtpByEmail(String email,UserDTO userDTO) {
			return null;
		}
		
		 default	Boolean resetPasswordByEmail(String email,String security,Integer otp, UserDTO userDTO) {
			return null;
		}
	
	
	
	
}
