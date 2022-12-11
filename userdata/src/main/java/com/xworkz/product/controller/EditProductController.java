package com.xworkz.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.product.service.ProductService;

@Controller
@RequestMapping("/editproduct")
public class EditProductController {
	
	@Autowired
	private ProductService productService;
	
	public EditProductController() {
		System.out.println("edit product controller is running");
		
	}
	
	
	

}
