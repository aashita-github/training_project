package com.nagarro.daoImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.nagarro.dao.*;
import org.hibernate.cfg.Configuration;

public class DaoImp implements Dao{
	private Configuration con = new Configuration().configure();
	private SessionFactory sessionFactory = con.buildSessionFactory();
	private Session session;

	public Session getSession() {
		return session;
	}

	public void begin() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}

	public void commit() {
		session.getTransaction().commit();
	}

	public void close() {
		session.close();
	}

	public void rollback() {
		session.getTransaction().rollback();
	}

}
