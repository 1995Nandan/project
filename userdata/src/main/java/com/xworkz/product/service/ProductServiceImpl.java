package com.xworkz.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.userdata.dao.ProductDAO;
import com.xworkz.userdata.dto.ProductDTO;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public Boolean validateAndSave(ProductDTO dto) {

		return productDAO.save(dto);
	}

	@Override
	public List<ProductDTO> validateAndFindAllProduct() {
		List<ProductDTO> allProduct = productDAO.findAllProduct();
		if (allProduct != null) {

			return allProduct;
		} else {

			System.out.println(" productList is  emty");
			return null;
		}
	}

	@Override
	public List<ProductDTO> validateAndFindByName(String productName) {
		List<ProductDTO> findByName = productDAO.findByName(productName);
		if (findByName != null) {
			return findByName;
		}
		return findByName;
	}

	@Override
	public Boolean validateAndupdateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail(String productName,
			String category, Double price, Integer stock, String updatedBy, String fileName, String userEmail) {

		Boolean andStockAndUpdatedDateByMail = productDAO
				.updateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail(productName, category, price,
						stock, updatedBy, fileName, userEmail);
		
		return andStockAndUpdatedDateByMail;
	}
}
