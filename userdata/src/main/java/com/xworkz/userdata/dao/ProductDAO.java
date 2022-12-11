package com.xworkz.userdata.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.xworkz.userdata.dto.ProductDTO;

public interface ProductDAO {

	default Boolean save(ProductDTO productDTO) {

		return true;
	}

	default List<ProductDTO> findAllProduct() {

		return null;
	}

	default List<ProductDTO> findByName(String productName) {
		return null;

	}

	default Boolean updateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail(String productName,
			String category, Double price, Integer stock, String updatedBy, String fileName, String userEmail) {
		return true;
	}

}
