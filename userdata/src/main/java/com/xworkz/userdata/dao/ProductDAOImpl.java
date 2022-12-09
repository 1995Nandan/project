package com.xworkz.userdata.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private EntityManagerFactory factory;
	private EntityManager manager;

	
	@Override
	public Boolean save(ProductDAO productDAO) {

		manager = factory.createEntityManager();
		try {

			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(productDAO);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.clear();

		}
		return true;
	}

}
