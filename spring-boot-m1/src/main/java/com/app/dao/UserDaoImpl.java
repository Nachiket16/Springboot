package com.app.dao;


import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // Mandatory cls level annotation to tell SC following is a spring bean : containing
			// DAL .SC enables exc translation mechanism (i.e SC will further translate hib
			// exc --> spring exc : un chked
//singleton n eager
public class UserDaoImpl implements IUserDao {
	//dependency : SF
	@Autowired //autowire=byType 
	//OR JPA annotation : @PersistenceContext
	private EntityManager manager;

	@Override
	public User authenticateUser(String email, String pass1) {
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		return manager.createQuery(jpql,User.class).
				setParameter("em", email).setParameter("pass", pass1).getSingleResult();
	}

}
