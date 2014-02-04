package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CityDAO;
import com.vaannila.dao.CityImpl;
import com.vaannila.dao.CountryDAO;
import com.vaannila.dao.CountryImpl;
import com.vaannila.domain.City;
import com.vaannila.domain.Country;

public class CityAction extends ActionSupport implements ModelDriven<City>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -384611401611075419L;

	private City city= new City();
	private CityDAO cityDAO=new CityImpl();
	private List<City> cityList=new ArrayList<City>();
	private List<Country> countryList=new ArrayList<Country>();
	private CountryDAO countryDAO=new CountryImpl();
	private Country country = new Country();
	
	@Override
	public City getModel() {
		return city;
	}
	
	public String saveOrUpdate()
	{	
		if(city.getCityName()==null){
			countryList=countryDAO.listCountry();
		}else{
			cityDAO.saveOrUpdateCity(city);
			countryList=countryDAO.listCountry();
		}
		return SUCCESS;
	}
	
	public String list()
	{
		cityList=cityDAO.listCity();
		countryList=countryDAO.listCountry();
		return SUCCESS;
	}
	
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		cityDAO.deleteCity(Integer.parseInt(request.getParameter("CityId")));
		return SUCCESS;
	}
	
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		System.out.println(request.getParameter("CityId"));
		city = cityDAO.listCityById(Integer.parseInt(request.getParameter("CityId")));
		cityList=cityDAO.listCity();
		countryList=countryDAO.listCountry();
		return SUCCESS;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
}
