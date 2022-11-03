package com.xworkz.userdata.service;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.UserDAO;
import com.xworkz.userdata.dto.UserDTO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public Boolean validateAndSave(UserDTO userDTO) {

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator Validator = validatorFactory.getValidator();
		Set<ConstraintViolation<UserDTO>> set = Validator.validate(userDTO);
		if (set.size() > 0) {
			System.out.println("Entered details are valid");
			return false;

		} else {
			System.out.println("Entered details are not valid");
			Boolean save = userDAO.save(userDTO);
			System.out.println(save);
			return true;
		}

	}

	@Override
	public Boolean getByEmail(String email) {
		System.out.println("Calling findByEmail Method");
		List<UserDTO> byEmail = userDAO.getByEmail(email);
		if(byEmail != null) {
			return false;
		}
		else {
			return true;
		}
	
	}

}
