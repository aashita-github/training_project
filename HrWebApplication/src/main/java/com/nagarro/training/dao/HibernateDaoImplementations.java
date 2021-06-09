package com.nagarro.training.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateDaoImplementations implements HibernateDao{
	private Configuration con=new Configuration().configure();
	private SessionFactory sessionFactory=con.buildSessionFactory();
	private Session session;

	@Override
	public Session getSession() {
		return session;
		
	}

	@Override
	public void begin() {
		session=sessionFactory.openSession();
		session.beginTransaction();
	}

	@Override
	public void commit() {
		session.getTransaction().commit();
	}

	@Override
	public void close() {
		session.close();
	}

	@Override
	public void rollback() {
		session.getTransaction().rollback();
	}
	

}
