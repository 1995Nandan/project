package com.xworkz.userdata.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.userdata.dto.UserDTO;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	private EntityManagerFactory factory;
	private EntityManager manager;

	@Override
	public Boolean save(UserDTO userDTO) {
		manager = factory.createEntityManager();
		try {
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(userDTO);
			transaction.commit();
		} catch (PersistenceException e) {
			e.printStackTrace();

		} finally {
			manager.clear();
		}
		return true;

	}

	@Override
	public List<UserDTO> getByEmail(String email) {
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("getByEmail");
			query.setParameter("email", email);
			List<UserDTO> list = query.getResultList();
			System.out.println(list);
			if (list.isEmpty()) {
				return null;
			} else if (!list.isEmpty()) {
				return list;

			}
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}

}
