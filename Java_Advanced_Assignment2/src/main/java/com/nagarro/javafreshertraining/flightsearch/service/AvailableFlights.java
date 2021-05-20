package com.nagarro.javafreshertraining.flightsearch.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.javafreshertraining.flightsearch.hibernate.HibernateUtil;
import com.nagarro.javafreshertraining.flightsearch.model.Flights;

/**
 * @author aashita
 *To display flights available for given arrival and departure loc on a date
 */
public class AvailableFlights {
	static int size;

	public static void flightsAvailable() {
		Session session = null;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();
			String hql = "from Flights f where depLoc=:depLoc and arrLoc=:arrLoc and seatAvailability='Y' and validTill=:validTill and classType=:classType";		
			Query qry = session.createQuery(hql);
			qry.setParameter("depLoc", Validations.depLoc);
			qry.setParameter("arrLoc", Validations.arrLoc);
			qry.setParameter("validTill", Validations.validTill);
			qry.setParameter("classType", Validations.classType);
			@SuppressWarnings("unchecked")
			List<Flights> list = qry.getResultList();
			 Set<Flights> hSet = new HashSet<Flights>(list);
		        hSet.addAll(list);
			size = hSet.size();
			System.out.println("Total Number Of Records : " + size);

			if (Validations.choiceCode == 1)
				FlightView.viewFlightsByFare(hSet);
			else if (Validations.choiceCode == 2)
				FlightView.viewFlightsByTime(hSet);
		} catch (HibernateException e) {

			System.out.print(e.getMessage());
		} finally {
			session.close();
		}
	}
}