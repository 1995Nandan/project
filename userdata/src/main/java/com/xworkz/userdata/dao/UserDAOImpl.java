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
	public UserDTO getByEmail(String email) {
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("getByEmail");
			query.setParameter("email", email);
			Object result = query.getSingleResult();
			UserDTO userDTO = (UserDTO) result;
			return userDTO;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			manager.close();
		}
		return null;
	}

	@Override
	public UserDTO findByEmailAndPassword(String email, String security) {
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			Query query = manager.createNamedQuery("findByEmailAndPassword");
			query.setParameter("emails", email);
			query.setParameter("pass", security);
			Object result = query.getSingleResult();
			UserDTO userDTO = (UserDTO) result;
			return userDTO;

		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
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
	public Boolean resetPasswordByEmail(String email, String security, String status, Integer otp,String reSecurity) {
		EntityManager manager = null;

		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("resetPasswordByEmail");
			query.setParameter("passs", security);
			query.setParameter("sts", status);
			query.setParameter("mass", email);
			query.setParameter("rs", reSecurity);
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
		EntityManager manager = null;
		try {
			manager = factory.createEntityManager();
			EntityTransaction transaction = manager.getTransaction();
			transaction.begin();
			Query query = manager.createNamedQuery("updateOtpByEmail");
			query.setParameter("ot", otp);
			query.setParameter("gmail", email);
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
	public Boolean updateUserDetailsByEmail(String username, String phoneno, String email, String fileName) {
		EntityManager Manager = factory.createEntityManager();
		{
			try {
				EntityTransaction transaction = manager.getTransaction();
				transaction.begin();
				Query query = manager.createNamedQuery("updateUserDetailsByEmail");
				query.setParameter("names", username);
				query.setParameter("number", phoneno);
				query.setParameter("mails", email);
				query.setParameter("file", fileName);
				query.executeUpdate();
				transaction.commit();
			} catch (PersistenceException e) {
				e.printStackTrace();
			} finally {
				manager.close();
			}
		}

		return true;
	}
	
	@Override
	public Boolean updatePhoneNoAndNameByEmail(String phoneno, String username, String email,String fileName) {
		EntityManager Manager = factory.createEntityManager();
		{
			try {
				EntityTransaction transaction = Manager.getTransaction();
				transaction.begin();
				Query query = Manager.createNamedQuery("updatePhoneNoAndNameByEmail");
				query.setParameter("name", username);
				query.setParameter("no", phoneno);
				query.setParameter("mail", email);
				query.setParameter("file", fileName);
				System.out.println(phoneno+username+email+"manoj is checking the issue ");
				int executeUpdate = query.executeUpdate();
				System.out.println(executeUpdate);
				transaction.commit();
			} catch (PersistenceException e) {
				e.printStackTrace();
			} finally {
				Manager.close();
			}
		}

		
		
		return true;
	}
}