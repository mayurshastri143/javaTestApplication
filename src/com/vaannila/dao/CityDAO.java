package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.City;


public interface CityDAO {
	public void saveOrUpdateCity(City city);
	public List<City> listCity();
	public City listCityById(int id);
	public void deleteCity(int id);
	public List<City> listCityByCountryId(int CountryId);
}
