package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CountryDAO;
import com.vaannila.dao.CountryImpl;
import com.vaannila.domain.Country;

public class CountryAction extends ActionSupport implements ModelDriven<Country>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -384611401611075419L;

	private Country country = new Country();
	private CountryDAO countryDAO=new CountryImpl();
	private List<Country> countryList=new ArrayList<Country>();
	
	@Override
	public Country getModel() {
		return country;
	}
	
	public String saveOrUpdate()
	{	
		if(country.getCountryName()==null){
			return SUCCESS;	
		}else{
			countryDAO.saveOrUpdateCountry(country);
		}
		
		return SUCCESS;
	}
	
	public String list()
	{
		countryList=countryDAO.listCountry();
		return SUCCESS;
	}
	
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		countryDAO.deleteCountry(Integer.parseInt(request.getParameter("CountryId")));
		return SUCCESS;
	}
	
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		country = countryDAO.listCountryById(Integer.parseInt(request.getParameter("CountryId")));
		countryList=countryDAO.listCountry();
		return SUCCESS;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	public List<Country> getCountryList() {
		return countryList;
	}

	public void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	

	
}
