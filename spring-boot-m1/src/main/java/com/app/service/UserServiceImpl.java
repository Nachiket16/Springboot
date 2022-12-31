package com.app.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service //Mandatory class level annotation to tell SC , follwoing is a spring bean : containing B.L
@Transactional //Mandatory class level annotation , to tell SC , to auto manage txs.
public class UserServiceImpl implements IUserService {
	//dependency : DAO layer i/f
	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String pass) {
		// TODO Auto-generated method stub
		return userDao.authenticateUser(email, pass);
	}

}
