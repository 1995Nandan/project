package com.xworkz.userdata.dto;

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
@NamedQueries({@NamedQuery(name="getByEmail",query="select user.userEmail from UserDTO user where user.userEmail=:email"),
	@NamedQuery(name="findByEmailAndPassword",query="select user from UserDTO user where user.userEmail=:email And user.password =:pass"),
	@NamedQuery(name="changeStatus", query="update UserDTO user set user.status = :stat where user.userEmail = :email"),
	@NamedQuery(name = "updateCount", query = "update UserDTO user set user.count = :cnt where user.userEmail = :email")})
public class UserDTO {

	public UserDTO() {
		System.out.println("Created:"+this.getClass().getSimpleName());
		
	}
	
	@Id
	@GenericGenerator(name = "save",strategy = "increment")
	@GeneratedValue(generator = "save")
	@Min(value = 1)
	private Integer id;
	@NotNull @NotEmpty @Length(min = 3)@Length(max = 50)
	private String username;
	@NotNull @NotEmpty @Length(min = 3)@Length(max = 50)
	private String email;
	@NotNull @NotEmpty @Length(min = 3)@Length(max = 50)
	private String phoneno;
    private  Integer count;
    private String status;
    private String security;
	
}
