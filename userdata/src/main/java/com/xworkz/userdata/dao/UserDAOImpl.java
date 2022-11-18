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

	@Override
	public List<UserDTO> findByEmailAndPassword(String email, String security) {
		EntityManager manager=null;
		try {
			manager=factory.createEntityManager();
			Query query = manager.createNamedQuery("findByEmailAndPassword");
			query.setParameter("emails", email);
			query.setParameter("pass", security);
			List<UserDTO> resultList = query.getResultList();
			System.out.println(resultList.size());
			if(resultList.isEmpty()) {
				return null;
			}
			else if (!resultList.isEmpty()) {
				return resultList;
			}	
		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
			
		}
		return null;
	}

	@Override
	public Boolean updateCountByEmail(Integer count, String email) {
		EntityManager manager = null;
		try {
			manager = this.factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query2 = manager.createNamedQuery("updateCount");
			query2.setParameter("cnt", count);
			query2.setParameter("gmail", email);
			query2.executeUpdate();
			transaction.commit();
		}

		catch (PersistenceException p) {
			p.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Boolean updateStatusByEmail(String email, String status) {

		EntityManager manager = null;
		try {
			manager = this.factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query2 = manager.createNamedQuery("changeStatus");
			query2.setParameter("stat", status);
			query2.setParameter("email", email);
			query2.executeUpdate();
			transaction.commit();
		}

		catch (PersistenceException p) {
			p.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	@Override
	public Boolean updatePasswordByEmail(String security, String email) {
		EntityManager manager = null;

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updatePasswordByEmail");
			query.setParameter("pass", security);
			query.setParameter("ma", email);
			query.executeUpdate();
			transaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}

	

	@Override
	public Boolean resetPasswordByEmail(String email, String security, String status, Integer otp) {
		EntityManager manager = null;

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("resetPasswordByEmail");
			query.setParameter("passs", security);
			query.setParameter("sts", status);
			query.setParameter("mass", email);
			query.executeUpdate();
			transaction.commit();

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return true;
	}
	
	@Override
	public Boolean updateOtpByEmail(Integer otp, String email) {
		EntityManager manager=null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updateOtpByEmail");
			query.setParameter("ot", otp);
			query.setParameter("gmail", email);
			query.executeUpdate();
			transaction.commit();
		}
		catch (PersistenceException e) {
			e.printStackTrace();
		}
		finally {
			manager.close();
		}
			return true;
		}
	}

