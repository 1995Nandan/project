package com.xworkz.userdata.dao;

import java.util.*;

import com.xworkz.userdata.dto.UserDTO;


public interface UserDAO {
	
	public Boolean save(UserDTO userDTO);
	
	public List<UserDTO> getByEmail(String email);
	
	public List<UserDTO>findByEmailAndPassword(String email,String password);
	
	public Boolean updateCountByEmail(Integer count,String email);
	
	public Boolean updateStatusByEmail(String email,String status);
	

}
