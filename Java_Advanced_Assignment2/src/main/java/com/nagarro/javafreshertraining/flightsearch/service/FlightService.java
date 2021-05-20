package com.nagarro.javafreshertraining.flightsearch.service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import com.nagarro.javafreshertraining.flightsearch.hibernate.HibernateUtil;
import com.nagarro.javafreshertraining.flightsearch.model.Flights;
import com.opencsv.CSVReader;

/**
 * @author aashita To execute watcher for first time and read csv files.Also
 *         call thread method.
 */
public class FlightService {

	public static boolean readFiles = true;
	public static List<String> files = new ArrayList<>();

	public Date convertStringToDate(String strDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			return formatter.parse(strDate);
		} catch (ParseException e) {

			e.printStackTrace();
		}
		return null;

	}

	public static void loadCSV() {
		FlightService.removeAllInstances(Flights.class);
		if (readFiles) {
			try {
				FileSearch f = new FileSearch();
				files = f.fileUtility();
				readFiles = false;

			} catch (IOException | InterruptedException e) {

				e.printStackTrace();

			}
		}
		FlightThread.useThread(files);
		try {

			for (String strFile : files) {
				populateDbFromFiles(strFile);

			}
		} catch (Exception e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}

	}

	public static void removeAllInstances(final Class<?> clazz) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		@SuppressWarnings("deprecation")
		final List<?> instances = session.createCriteria(clazz).list();
		for (Object obj : instances) {
			session.delete(obj);
		}
		session.getTransaction().commit();
	}

	public static void countFlights() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			@SuppressWarnings("deprecation")
			Criteria cr = session.createCriteria(Flights.class);

			// To get total row count.
			cr.setProjection(Projections.rowCount());
			List<?> rowCount = cr.list();

			System.out.println("Total Coint: " + rowCount.get(0));
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public static void readCsv(Session session, String[] record) {
		for (int i = 0; i < record.length; i++) {

			Flights flightObject = new Flights();

			String[] records = record[i].split("\\|");
			flightObject.setFlightNo(records[0]);
			flightObject.setDepLoc(records[1]);
			flightObject.setArrLoc(records[2]);
			flightObject.setValidTill(records[3]);
			flightObject.setFlightTime(records[4]);
			flightObject.setFlightDur(Float.parseFloat(records[5]));
			flightObject.setFare(Integer.parseInt(records[6]));
			flightObject.setSeatAvailability(records[7]);
			flightObject.setClassType(records[8]);

			String key = flightObject.getDepLoc() + flightObject.getArrLoc();
			flightObject.setKey(key);

			session.persist(flightObject);

		}

	}

	/**
	 * @param strFile
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void populateDbFromFiles(String strFile) throws FileNotFoundException, IOException {
		CSVReader reader;
		reader = new CSVReader(new FileReader(strFile), ',', '\'', 1);
		String[] record = null;
		Session session = null;
		Transaction trans = null;
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			session = factory.openSession();

			trans = session.beginTransaction();
			while ((record = reader.readNext()) != null) {
				FlightService.readCsv(session, record);

			}
		} catch (HibernateException e) {
			System.out.println(e.getMessage());
		} finally {
			trans.commit();
			session.close();

			reader.close();
		}
	}
}
