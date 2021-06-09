package com.nagarro.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nagarro.dao.FlightSearchDao;
import com.nagarro.dao.FlightSearchDaoImpl;
import com.nagarro.dao.HibernateDao;
import com.nagarro.dao.HibernateDaoImpl;
import com.nagarro.dao.LoginDao;
import com.nagarro.dao.LoginDaoImpl;
import com.nagarro.service.FlightSearchService;
import com.nagarro.service.LoginService;

@Configuration
public class AppConfig {

	@Bean
	public HibernateDao getHibernateDao() {
		return new HibernateDaoImpl();
	}
	
	@Bean
	public LoginDao getLoginDao() {
		return new LoginDaoImpl();
	}
	
	@Bean
	public FlightSearchDao getFlightSearchDao() {
		return new FlightSearchDaoImpl();
	}
	
	@Bean
	public LoginService getLoginService() {
		return new LoginService();
	}
	
	@Bean
	public FlightSearchService getFlightSearchService() {
		return new FlightSearchService();
	}
}
