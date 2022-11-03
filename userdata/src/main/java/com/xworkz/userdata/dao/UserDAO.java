package com.xworkz.userdata.dao;

import java.util.*;

import com.xworkz.userdata.dto.UserDTO;


public interface UserDAO {
	
	public Boolean save(UserDTO userDTO);
	
	public List<UserDTO> getByEmail(String email);
	

}
