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
	
}
