package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CityDAO;
import com.vaannila.dao.CityDAOImpl;
import com.vaannila.dao.CountryDAO;
import com.vaannila.dao.CountryDAOImpl;
import com.vaannila.dao.UserDAO;
import com.vaannila.dao.UserDAOImpl;
import com.vaannila.domain.City;
import com.vaannila.domain.Country;
import com.vaannila.domain.User;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private static final long serialVersionUID = -6659925652584240539L;

	static Logger log = Logger.getLogger(UserAction.class.getName());

	private User user = new User();
	private Country country = new Country();
	private List<User> userList = new ArrayList<User>();
	private List<Country> countryList = new ArrayList<Country>();
	private List<City> cityList = new ArrayList<City>();
	private UserDAO userDAO = new UserDAOImpl();
	private CountryDAO countryDAO = new CountryDAOImpl();
	private CityDAO cityDAO = new CityDAOImpl();
	private SessionMap<String,Object> sessionMap;  
	
	@Override
	public User getModel() {
		return user;
	}

	public String saveOrUpdate() {
		userDAO.saveOrUpdateUser(user);
		return SUCCESS;
	}

	public String list() {
		userList = userDAO.listUser();
		countryList = countryDAO.listCountry();
		
		return SUCCESS;
	}

	public String delete() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		userDAO.deleteUser(Long.parseLong(request.getParameter("id")));
		return SUCCESS;
	}

	public String edit() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		user = userDAO.listUserById(Long.parseLong(request.getParameter("id")));
		countryList = countryDAO.listCountry();
		return SUCCESS;
	}

	public String selectCity() {
		HttpServletRequest request = (HttpServletRequest) ActionContext
				.getContext().get(ServletActionContext.HTTP_REQUEST);
		cityList = cityDAO.listCityByCountryId(Integer.parseInt(request
				.getParameter("CountryId")));
		return SUCCESS;
	}

	
	
	/************************************************************************************************************************************************************/
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
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
	
	public List<City> getCityList() {
		return cityList;
	}

	public void setCityList(List<City> cityList) {
		this.cityList = cityList;
	}

	public SessionMap<String, Object> getSessionMap() {
		return sessionMap;
	}

	public void setSessionMap(SessionMap<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
	}
	
	
}
