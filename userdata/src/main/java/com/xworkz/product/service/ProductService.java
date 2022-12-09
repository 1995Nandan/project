package com.xworkz.product.service;

import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.ProductDAO;

public interface ProductService {

	default Boolean  validateAndSave(ProductDAO productDAO) {

		return true;

	}

}
