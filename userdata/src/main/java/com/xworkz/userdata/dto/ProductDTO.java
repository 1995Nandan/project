package com.xworkz.userdata.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@ToString
@Table(name = "product")

public class ProductDTO {

	public ProductDTO() {
		System.out.println("Product dto is Running");

	}

	@Id
	@GenericGenerator(name = "save", strategy = "increment")
	@GeneratedValue(generator = "save")
	private Integer id;
	private String productName;
	private String userEmail;
	private String category;
	private Double price;
	private String fileName;
	private String createdBy;
	private LocalDateTime createdDate;
	private String updatedBy;
	private LocalDateTime updatedDate;
	private Integer stock;

}
