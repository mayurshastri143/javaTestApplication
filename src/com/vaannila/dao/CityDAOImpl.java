package com.vaannila.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.City;

public class CityDAOImpl extends GenericDAOImpl<City, Long> implements CityDAO {
	
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCityByCountryId(int CountryId){
		List<City> courses = null;
		try{
			Query query = session.createQuery("from City where CountryId = :CountryId ");
			query.setParameter("CountryId", CountryId);
			courses = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return courses;
	}
	
}
