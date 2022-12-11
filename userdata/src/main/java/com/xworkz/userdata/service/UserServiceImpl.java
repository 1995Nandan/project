package com.xworkz.userdata.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

import javax.mail.Authenticator;
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
import com.xworkz.userdata.dto.UserDTO;
import com.xworkz.userdata.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	int count = 0;

	@Autowired
	private UserDAO userDAO;
	private LocalDateTime dateTime;

	@Override
	public Boolean validateAndSave(UserDTO userDTO) {

		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator Validator = validatorFactory.getValidator();
		Set<ConstraintViolation<UserDTO>> set = Validator.validate(userDTO);
		if (set.size() > 0) {
			System.err.println("Entered details are Invalid");
			return false;

		} else {
			System.out.println("Entered details are valid");
			String passwordGenertaor = password();
			String status = "unblocked";
			Integer count = 0;
			if (!passwordGenertaor.isEmpty()) {
				userDTO.setSecurity(passwordGenertaor);
				userDTO.setCount(count);
				userDTO.setStatus(status);
				Boolean save = userDAO.save(userDTO);
				if (save) {
					Boolean sendMail = sendEmail(userDTO.getEmail(), userDTO.getSecurity(), userDTO);
				}
				System.out.println(save);
				return true;
			}
		}
		return true;

	}

	@Override
	public UserDTO getByEmail(String email) {
		System.out.println("Calling findByEmail Method");
		UserDTO byEmail = userDAO.getByEmail(email);
		if (byEmail != null) {
			return byEmail;
		} else {
			return null;
		}

	}

	@Override
	public Boolean sendEmail(String email, String password, UserDTO userDTO) {
		String name = userDTO.getUsername();
		String security = userDTO.getSecurity();

		// Recipient's email ID needs to be mentioned
		String to = email;

		// Sender's email ID needs to be mentioned
		String from = "nandansk925@gmail.com";

		// Assuming you are sending email from through Out LooK smtp
		String host = "smtp.office365.com";

		// password for the Mail
		String pass = "nandansonu225";

		// Get system properties
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
	public UserDTO findByEmailAndPassword(String email, String security, UserDTO userDTO) {

		UserDTO findByEmailAndPassword = userDAO.findByEmailAndPassword(userDTO.getEmail(), userDTO.getSecurity());
		System.out.println("Email and Password in Service" + findByEmailAndPassword);
		if (findByEmailAndPassword != null) {
			this.count = 0;
			userDAO.updateCountByEmail(count, email);
			return findByEmailAndPassword;
		} else {
			this.count++;
		}
		if (this.count <= 3) {
			userDAO.updateCountByEmail(count, email);
		}
		if (count >= 3) {
			userDTO.setStatus("blocked");
			userDAO.updateStatusByEmail(email, userDTO.getStatus());
		}

		return findByEmailAndPassword;
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

	@Override
	public Boolean updatePasswordByEmail(String security, String email) {
		System.out.println("Running updatePasswordByEmail");
		if (security.length() < 10 && security.length() >= 12 && security != null) {
			System.out.println("Password length is incorrect and plz match the condtion");
		} else {
			System.out.println("Security is valid");
			UserDTO byEmail = userDAO.getByEmail(email);

			if (byEmail == null) {
				System.out.println("findByEmail is null");
				return null;
			} else {
				Boolean updatePasswordByEmail = userDAO.updatePasswordByEmail(security, email);
				if (updatePasswordByEmail) {
					System.out.println("updatePasswordByEmail is  correct");
					return true;
				} else {
					System.err.println("updatePasswordByEmail is not correct");
					return false;

				}
			}

		}
		return false;
	}

	@Override
	public Integer otpGeneration() {
		int randomPin = (int) (Math.random() * 9000) + 1000;
		Integer otp = Integer.valueOf(randomPin);
		System.out.println(otp);
		return otp;
	}

	@Override
	public Boolean updateOtpByEmail(String email, UserDTO userDTO) {
		System.out.println("Running updateOtpByEmail");
		Integer otpGeneration = otpGeneration();
		this.sendOTPMail(email, otpGeneration, userDTO);
		System.out.println(otpGeneration);
		//userDTO.setOtp(otpGeneration);
		userDAO.updateOtpByEmail(otpGeneration, userDTO.getEmail());
		
		return true;
	}

	@Override
	public Boolean resetPasswordByEmail(String email, String security, Integer otp, UserDTO userDTO,
			String reSecurity) {
		System.out.println("Running resetPasswordByEmail");
		System.out.println("%%%%%%%%%%%%%");
		System.out.println(otp+"otp123456789asdfghjkl");
		UserDTO findByEmail = userDAO.getByEmail(email);
		System.out.println(findByEmail);
		if (findByEmail != null) {
			Integer otp2 = findByEmail.getOtp();
			System.out.println(otp2);
			if (otp2.equals(otp)) {
				System.out.println("Comparing otp2 with otp");
				userDTO.setSecurity(security);
				userDTO.setStatus("unBlocked");
				Boolean resetPasswordByEmail = userDAO.resetPasswordByEmail(email, userDTO.getSecurity(),
						userDTO.getStatus(), userDTO.getOtp(), userDTO.getReSecurity());
				if (resetPasswordByEmail) {
					System.out.println("ResetPassword");
				} else {
					System.out.println("OTP is Not Match");
				}
			} else {
				return false;
			}

		}
		return true;

	}

	@Override
	public Boolean sendOTPMail(String otpMail, Integer otp, UserDTO userDTO) {
		String to = otpMail;

		String from = "nandansk925@gmail.com";

		String host = "smtp.office365.com";

		String password = "nandansonu225";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", host);
		properties.put("mail.smtp.port", "587");
		// properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.debug", "true");
		properties.put("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(from, password);

			}

		});
		session.setDebug(true);
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			String email = userDTO.getEmail();
			Integer otp2 = userDTO.getOtp();
			message.setSubject("OTP For Reset Password");
			message.setText(
					"Hi" + " " + email + " " + "your OTP for Password Reset is" + " " + " " + otp + " " + "Thank You");

			System.out.println("Sending........");

			Transport.send(message);

			System.out.println("Sent message Succesfully");
			System.out.println("MessagingException may occurs");
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		return true;
	}

//	@Override
//	public String EncryptedPassword() {
//		System.out.println("Running EncryptedPassword ");
//		// logger.info("Running EncryptedPassword ");
//		Encoder encoder = Base64.getEncoder();
//		String password = password();
//		String encodeToString = encoder.encodeToString(password.getBytes());
//		System.out.println("EncryptedPassword" + " " + encodeToString);
//		return encodeToString;
//	}
//
//	@Override
//	public String EncryptPassword(String password) {
//		System.out.println("Running EncryptPassword ");
//		// logger.info("Running EncryptedPassword ");
//		Encoder encoder = Base64.getEncoder();
//		String passwords = password;
//		String encodeToString = encoder.encodeToString(passwords.getBytes());
//		System.out.println("EncryptedPassword" + " " + encodeToString);
//		return encodeToString;
//
//	}
//
//	@Override
//	public String DecryptedPassword(String encryptPassword) {
//		System.out.println("Running DecryptedPassword");
//		// logger.info("Running DecryptedPassword");
//		Decoder decoder = Base64.getDecoder();
//		byte[] decode = decoder.decode(encryptPassword);
//		String decrypt = new String(decode);
//		System.out.println("DecryptedPassword" + decrypt);
//		return decrypt;
//
//	}

	@Override
	public Boolean updateOtpDateAndTimeByMail(Integer otp, LocalDate date, LocalTime time, String email,
			UserDTO userDTO) {
		System.out.println(" running on the updateOtpDateAndTimeByMail");
		System.out.println("otp+++++++"+otp);

		UserDTO byEmail = userDAO.getByEmail(email);
		if (byEmail != null) {
			System.out.println(" running in side the if updateotp");
			Integer otpGeneration = this.otpGeneration();
			dateTime = LocalDateTime.now();
			LocalDate localDate = dateTime.toLocalDate();
			LocalTime localTime = dateTime.toLocalTime();
			userDTO.setDate(localDate);
			userDTO.setTime(localTime);

			userDTO.setOtp(otpGeneration);
			Boolean byMail = userDAO.updateOtpDateAndTimeByMail(otpGeneration, userDTO.getDate(), userDTO.getTime(), userDTO.getEmail());
			if(byMail) {
				
				
				Boolean sendOTPMail = sendOTPMail(email, otpGeneration, userDTO);
				
				if(sendOTPMail) {
					
					System.out.println("otp is sed successfully");
					
				}
				else {
					
					System.out.println(" mail is  invalid");
				}
			}
			else {
				
				System.out.println(" mail is not matched");
			}

		}
		return true;
	}

}
