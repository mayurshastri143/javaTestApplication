package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.City;

public interface CityDAO extends GenericDAO<City, Long>{
	public List<City> listCityByCountryId(int CountryId);
}
