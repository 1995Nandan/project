package com.xworkz.userdata.service;

import com.xworkz.userdata.dto.UserDTO;

public interface UserService {

	public Boolean validateAndSave(UserDTO userDTO);
	
	public Boolean getByEmail(String email);
}
