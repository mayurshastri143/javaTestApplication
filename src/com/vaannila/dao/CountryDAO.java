package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Country;


public interface CountryDAO {
	public void saveOrUpdateCountry(Country country);
	public List<Country> listCountry();
	public Country listCountryById(int id);
	public void deleteCountry(int id);
}
