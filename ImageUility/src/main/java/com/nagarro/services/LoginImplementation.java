package com.nagarro.services;

import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;
import com.nagarro.hibernate.HibernateUtil;
import com.nagarro.interfaces.LoginInterface;
import com.nagarro.model.Image;
import com.nagarro.model.User;

public class LoginImplementation implements LoginInterface {

	public void saveUser(User user) {
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionInstance()) {

			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	@Override

	public Boolean userAuthentication(String username, String password) {
		Transaction transaction = null;
		System.out.println(username);
		System.out.println(password);
		try (Session session = HibernateUtil.getSessionInstance()) {
			transaction = session.beginTransaction();
			String pass = (String) session.createQuery("Select U.password FROM User U WHERE U.username = :username")
					.setParameter("username", username).uniqueResult();
			System.out.print(pass);
			if (pass.equals(password)) {
				return true;
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				return false;
			}
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public User getUserDetails(String username) {
		User user = null;

		try (Session session = HibernateUtil.getSessionInstance()) {
			session.getTransaction().begin();
			int id = getUserId(username);
			user = session.get(User.class, id);
			System.out.println("returnin login details " + id);
			System.out.print(user);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}

	public void updatePassword(int id, String username, String password) {
		User user = null;
		try (Session session = HibernateUtil.getSessionInstance()) {
			session.getTransaction().begin();
			user = session.get(User.class, id);
			user.setPassword(password);
			session.update(user);
			System.out.println(user.toString());
			session.getTransaction().commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getUserId(String username, String password) {
		String hql = "from User where username=:username and password=:password";
		Session session = HibernateUtil.getSessionInstance();

		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		query.setParameter("password", password);
		User details = (User) query.getSingleResult();
		return details.getId();

	}

	@SuppressWarnings("unchecked")
	public static List<Image> getAllDetails(int id) {
		String hql = "from Image";
		Session session = HibernateUtil.getSessionInstance();
		Query query = session.createQuery(hql);
		return query.getResultList();

	}

	public static User getUserId(int id) {
		Session session = HibernateUtil.getSessionInstance();
		session.beginTransaction();
		User loginDetail = session.get(User.class, id);
		session.getTransaction().commit();
		session.close();
		return loginDetail;

	}

	public static int getUserId(String username) {
		String hql = "from User where username=:username";
		Session session = HibernateUtil.getSessionInstance();
		Query query = session.createQuery(hql);
		query.setParameter("username", username);
		User details = (User) query.getSingleResult();
		return details.getId();

	}

	@SuppressWarnings("deprecation")
	public static double getTotalSize() {

		double totalSize, temp;
		Session session = HibernateUtil.getSessionInstance();
		try {
			temp = (double) session.createCriteria(Image.class).setProjection(Projections.sum("imageSize"))
					.uniqueResult();
			totalSize = temp;
		} catch (NullPointerException ex) {
			totalSize = 0L;
		}
		System.out.println(totalSize);
		return totalSize;

	}

	public static void addLoginDetails(User loginDetails) {
		Session session = HibernateUtil.getSessionInstance();
		session.beginTransaction();
		session.saveOrUpdate(loginDetails);
		session.getTransaction().commit();
		session.close();

	}

}