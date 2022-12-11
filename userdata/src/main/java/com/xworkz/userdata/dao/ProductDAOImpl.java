package com.xworkz.userdata.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.userdata.dto.ProductDTO;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManagerFactory factory;
	private EntityManager manager;

	@Override
	public Boolean save(ProductDTO productDTO) {

		manager = factory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(productDTO);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.clear();

		}
		return true;
	}

	@Override
	public List<ProductDTO> findAllProduct() {

		manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("findAllProduct");
			// query.setParameter("mail",mail );
			List list = query.getResultList();
			return list;
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public List<ProductDTO> findByName(String productName) {
		manager = factory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("findByName");
			query.setParameter("name", productName);
			List resultList = query.getResultList();
			System.out.println(resultList.isEmpty());
			return resultList;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}

		return ProductDAO.super.findByName(productName);
	}

	@Override
	public Boolean updateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail(String productName,
			String category, Double price, Integer stock, String updatedBy, String fileName, String userEmail) {

		manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager
					.createNamedQuery("updateNameAndCategoryAndPriceAndFilenameAndStockAndUpdatedDateByMail");
			query.setParameter("name", productName);
			query.setParameter("cat", category);
			query.setParameter("pr", price);
			query.setParameter("st", stock);
			query.setParameter("fn", fileName);
			query.setParameter("mail", userEmail);
			query.setParameter("up", updatedBy);
			query.executeUpdate();
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			manager.close();

		}

		return true;
	}
	
	
}

