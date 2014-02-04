package com.vaannila.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.City;

public class CityImpl implements CityDAO {
	
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	@Override
	public void saveOrUpdateCity(City city) {
		try {
			session.saveOrUpdate(city);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void deleteCity(int CityId) {
		try {
			City city = (City) session.get(City.class, CityId);
			session.delete(city);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to list all the users.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<City> listCity() {
		List<City> courses = null;
		try {
			courses = session.createQuery("from City").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public City listCityById(int CityId) {
		City city = null;
		try {
			city = (City) session.get(City.class, CityId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return city;
	}
	
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
