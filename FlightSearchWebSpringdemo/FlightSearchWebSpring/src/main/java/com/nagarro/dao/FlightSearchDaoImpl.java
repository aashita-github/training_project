package com.nagarro.dao;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.nagarro.constants.FinalValues;
import com.nagarro.csv.LoadCSV;
import com.nagarro.csv.ReadCSV;
import com.nagarro.dto.Flight;

public class FlightSearchDaoImpl implements FlightSearchDao{
	@Autowired
	private HibernateDao hibernateDao;

	@Override
	@Scheduled(fixedRate = 7000, initialDelay = 5000)
	public List<Flight> getAvailableFlights(HttpServletRequest request) {
		String hql = FinalValues.GET_AVAILABLE_FLIGHTS_HQL;
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		@SuppressWarnings("unchecked")
		Query<Flight> q = session.createQuery(hql);
		q.setParameter("dep_loc", request.getParameter("dep_loc"));
		q.setParameter("arr_loc", request.getParameter("arr_loc"));
		DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;

		String date = request.getParameter("flight_date");
		LocalDate flight_date = LocalDate.parse(date, formatter);

		q.setParameter("date", flight_date);
		List<Flight> available = q.getResultList();
		return available;
	}

	@Override
	public void addToDB() {
		File[] files = new File[3];
		
		List<Flight> flights = new ArrayList<>();
		LoadCSV loadcsvobj = new LoadCSV();
		files = loadcsvobj.load();
		ReadCSV readcsvobj = new ReadCSV();
		for (File file : files) {
			String path = file.getPath();
			path = path.replace('\\', '/');
			flights.addAll(readcsvobj.read(path));
		}
		addFlight(flights);
	}

	@Override
	public void removeFromDB() {
		String hql = FinalValues.DELETE_HQL;
		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		@SuppressWarnings("rawtypes")
		Query query = session.createQuery(hql);
		query.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public void addFlight(List<Flight> flights) {

		hibernateDao.begin();
		Session session = hibernateDao.getSession();
		for(Flight f : flights) {
			session.save(f);
		}
		session.getTransaction();
		hibernateDao.commit();
		hibernateDao.close();
		
	}

}
