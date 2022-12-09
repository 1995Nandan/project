package com.xworkz.userdata.dao;

public interface ProductDAO {

	default Boolean save(ProductDAO productDAO) {
		
		return true;
	}

}
