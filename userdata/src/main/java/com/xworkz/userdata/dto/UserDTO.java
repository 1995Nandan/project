package com.xworkz.userdata.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "userdata")
@NamedQueries({ @NamedQuery(name = "getByEmail", query = "select user from UserDTO user where user.email=:email"),
		@NamedQuery(name = "findByEmailAndPassword", query = "select user from UserDTO user where user.email=:emails and user.security =:pass"),
		@NamedQuery(name = "changeStatus", query = "update UserDTO user set user.status = :stat where user.email = :email"),
		@NamedQuery(name = "updateCount", query = "update UserDTO user set user.count = :cnt where user.email = :gmail"),
		@NamedQuery(name = "updatePasswordByEmail", query = "update UserDTO com set com.security=:pass where com.email=:ma"),
		@NamedQuery(name = "resetPasswordByEmail", query = "update UserDTO as com set com.security=:passs, com.status=:sts,com.reSecurity=:rs where com.email=:mass"),
		@NamedQuery(name = "updateOtpByEmail", query = "update UserDTO com set com.otp=:ot where com.email=:gmail"),
        @NamedQuery(name="updateUserDetailsByEmail",query = "update UserDTO as com set com.username=:names,com.phoneno=:number,com.fileName=:file where com.email=:mails"),
        @NamedQuery(name = "findAll", query = "Select com from UserDTO  com"),
        @NamedQuery(name="updatePhoneNoAndNameByEmail",query = "update UserDTO as com set com.username=:name,com.phoneno=:no,com.fileName=:file where com.email=:mail"),
        @NamedQuery(name = "updateOtpDateAndTimeByMail",query = "update UserDTO com set com.otp=:ot,com.date=:dt,com.time=:tm where com.email=:mail")})
public class UserDTO {

	public UserDTO() {
		System.out.println("Created:" + this.getClass().getSimpleName());

	}

	@Id
	@GenericGenerator(name = "save", strategy = "increment")
	@GeneratedValue(generator = "save")
	@Min(value = 1)
	private Integer id;
	@NotNull
	@NotEmpty
	@Length(min = 3)
	@Length(max = 50)
	private String username;
	@NotNull
	@NotEmpty
	@Length(min = 3)
	@Length(max = 50)
	private String email;
	@NotNull
	@NotEmpty
	@Length(min = 3)
	@Length(max = 50)
	private String phoneno;
	private Integer count;
	private String status;
	private String security;
	private Integer otp;
	private LocalDate date;
	private LocalTime time;
	private String fileName;
	private String reSecurity;
	
	

}
