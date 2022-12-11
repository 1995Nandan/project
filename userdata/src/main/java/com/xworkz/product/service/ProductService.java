package com.xworkz.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.ProductDAO;
import com.xworkz.userdata.dto.ProductDTO;

public interface ProductService {

	default Boolean  validateAndSave(ProductDTO productDTO) {

		return true;

	}
	default List<ProductDTO> validateAndFindAllProduct() {

		return null;
	}
	 List<ProductDTO> validateAndFindByName(String productName) ;
	 
	 default Boolean validateAndupdateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail(String productName,
			 
				String category, Double price, Integer stock, String updatedBy, String fileName, String userEmail) {
			return true;
		

	 }


}
