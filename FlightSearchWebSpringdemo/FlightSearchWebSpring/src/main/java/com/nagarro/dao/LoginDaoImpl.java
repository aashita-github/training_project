package com.nagarro.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.nagarro.dto.User;

public class LoginDaoImpl implements LoginDao {
	@Autowired
	private HibernateDao hibernateDao;
	@Override
	public User getUserDetails(String username) {
		User user = null;
		hibernateDao.begin();
		user = hibernateDao.getSession().get(User.class, username);
		hibernateDao.commit();
		hibernateDao.close();
		return user;
	}

	@Override
	public void updatePassword(String username, String password) {
		User user = null;
		user = getUserDetails(username);
		user.setPassword(password);
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		session.update(user);
		session.getTransaction();
		hibernateDao.commit();
		hibernateDao.close();
	}

	@Override
	public void signup(User user) {
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		session.save(user);
		session.getTransaction();
		hibernateDao.commit();
		hibernateDao.close();
	}

}
