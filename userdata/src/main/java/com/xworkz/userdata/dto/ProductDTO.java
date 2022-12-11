package com.xworkz.userdata.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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

@NamedQueries({ @NamedQuery(name = "findAllProduct", query = "select com from ProductDTO com"),
		@NamedQuery(name = "findByName", query = "select com from ProductDTO com where com.productName=:name"),
		@NamedQuery(name = "updateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail", query = "update ProductDTO com set "
				+ "com.productName=:name,com.category=:cat,com.price=:pr,com.stock=:st,com.updatedBy=:up,com.fileName=:fn where com.userEmail=:mail"),
		})

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
