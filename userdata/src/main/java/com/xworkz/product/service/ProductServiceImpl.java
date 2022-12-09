package com.xworkz.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductDAO productDAO;
	
	
	@Override
	public Boolean validateAndSave(ProductDAO productDAO) {
		
		return productDAO.save(productDAO);
	}
	

}
