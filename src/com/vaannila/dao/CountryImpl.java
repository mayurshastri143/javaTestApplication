package com.vaannila.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.Country;

public class CountryImpl implements CountryDAO {
	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	/**
	 * Used to save or update a user.
	 */
	@Override
	public void saveOrUpdateCountry(Country country) {
		try {
			session.saveOrUpdate(country);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	/**
	 * Used to delete a user.
	 */
	@Override
	public void deleteCountry(int id) {
		try {
			Country country= (Country) session.get(Country.class, id);
			session.delete(country);
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
	public List<Country> listCountry() {
		List<Country> courses = null;
		try {
			courses = session.createQuery("from Country").list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courses;
	}

	/**
	 * Used to list a single user by Id.
	 */
	@Override
	public Country listCountryById(int id) {
		Country country = null;
		try {
			country = (Country) session.get(Country.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return country;
	}
}
