package com.xworkz.userdata.dao;

import java.util.*;

import com.xworkz.userdata.dto.UserDTO;


public interface UserDAO {
	
	public Boolean save(UserDTO userDTO);
	
	public UserDTO getByEmail(String email);
	
	public UserDTO findByEmailAndPassword(String email,String security);
	
	public Boolean updateCountByEmail(Integer count,String email);
	
	public Boolean updateStatusByEmail(String email,String status);
	
    Boolean updatePasswordByEmail(String security, String email);
	
	Boolean updateOtpByEmail(Integer otp,String email);
	
	Boolean resetPasswordByEmail(String email,String security,String status,Integer otp);
	
	default Boolean updateUserDetailsByEmail(String name,String phoneno,String email,String fileName) {
		return true;
	}
	
	default Boolean updatePhoneNoAndNameByEmail(String phoneno,String username,String email) {
		return true;
	}
	
	

}
