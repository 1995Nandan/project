package com.xworkz.userdata.dto;

import java.util.*;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.UserDAO;
import com.xworkz.userdata.service.UserService;

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

	@Override
	public Boolean sendEmail(String email, String password, UserDTO userDTO) {
		String name =userDTO.getUsername();
		String security=userDTO.getSecurity();
		
		
		//Recipient's email ID needs to be mentioned
		String to = email;
		
		//Sender's email ID needs to be mentioned
		String from ="nandansk925@gmail.com";
				
	    //Assuming you are sending email from through Out LooK smtp
		String host ="smtp.office365.com";
		
		//password for the Mail
		String pass ="nandansonu225";
		
		//Get system properties
		Properties properties = System.getProperties();
		
		
		//// Setup mail server
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.transport.protocol", "smtp");
		
		// Get the Session object.// and pass username and password
				Session session = Session.getInstance(properties, new javax.mail.Authenticator() {

					protected PasswordAuthentication getPasswordAuthentication() {

						return new PasswordAuthentication(from, pass);

					}

				});

				// Used to debug SMTP issues
				session.setDebug(true);

				try {
					// Create a default MimeMessage object.
					MimeMessage message = new MimeMessage(session);

					// Set From: header field of the header.
					message.setFrom(new InternetAddress(from));

					// Set To: header field of the header.
					message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

					// Set Subject: header field
					message.setSubject("Registration Confirmation Mail");

					// Now set the actual message
					message.setText("Hi" + " " + name + " " + " " + security
							+ "This Is To Confirm You That Your Registration Was Successful" + " " + "Thank You");

					System.out.println("sending...");
					// Send message
					Transport.send(message);
					System.out.println("Sent message successfully....");
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}

				return true;
			}		
			
	
	@Override
	public List<UserDTO> findByEmailAndPassword(String email, String password, UserDTO userDTO) {
		Integer count=0;	
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Set<ConstraintViolation<String>> set = validator.validate(password);
		if (set.size() > 0) {
			System.out.println("Invalid Crentials Entered");
		} else {
			List<UserDTO> byEmail = userDAO.getByEmail(email);
			if (byEmail != null) {
				count = byEmail.get(0).getCount();
				List<UserDTO> findByEmailAndPassword = userDAO.findByEmailAndPassword(email, password);
				if(findByEmailAndPassword != null){
					return findByEmailAndPassword;
				}
				else if (findByEmailAndPassword == null) {
					Integer integer = count++;
					userDAO.updateCountByEmail(integer, email);
					if (count >= 3) {
						userDTO.setStatus("Blocked");
						userDAO.updateStatusByEmail(email, userDTO.getStatus());
					}
				}
			}
			
		}
		return null;
	}

	

	@Override
	public void updateCountByEmail(Integer count, String email) {
		System.out.println("Calling Update Count Method");
		userDAO.updateCountByEmail(count, email);
		System.out.println("Count Updated");
			
	}

	@Override
	public void updateStatus(String email, String status) {
		System.out.println("Calling updateStatus Method");
		Boolean statusUpdated = userDAO.updateStatusByEmail(email, status);
		System.out.println(statusUpdated);
		
	}
	@Override
	public String password() {
		String upperCase = "QWERTYUIOPASDFGHJKLZXCVBNM";
		String lowerCase = "qwertyuiopasdfghjklzxcvbnm";
		String num = "0123456789";
		String specialChar = "!@#$%&";
		String combination = upperCase + lowerCase + num + specialChar;
		int length = 12;
		char[] password = new char[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			password[i] = combination.charAt(random.nextInt(combination.length()));
		}
		return new String(password);
	}
}


