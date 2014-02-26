package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CompanyDAO;
import com.vaannila.dao.CompanyDAOImpl;
import com.vaannila.dao.CompanyTypeDAO;
import com.vaannila.dao.CompanyTypeDAOImpl;
import com.vaannila.domain.City;
import com.vaannila.domain.Company;
import com.vaannila.domain.CompanyType;


public class CompanyAction extends ActionSupport implements ModelDriven<Company> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1126284124632913405L;
	private Company company= new Company();
	private CompanyDAO companyDAO=new CompanyDAOImpl();
	private List<Company> companyList=new ArrayList<Company>();
	private List<CompanyType> companyTypeList=new ArrayList<CompanyType>();
	private CompanyTypeDAO companyTypeDAO=new CompanyTypeDAOImpl();
	private CompanyType companyType= new CompanyType();
	
	@Override
	public Company getModel() {
		return company;
	}

	public String saveOrUpdate()
	{	
		if(company.getCompanyName()==null){
			companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		}else{
			companyDAO.save(company);
			companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		}
		return SUCCESS;
	}
	
	public String list()
	{
		companyList=companyDAO.findAll(Company.class);
		companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		return SUCCESS;
	}
	
	public String delete()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		companyDAO.delete(company);
		return SUCCESS;
	}
	
	public String edit()
	{
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		company= companyDAO.findByID(Company.class, Integer.parseInt(request.getParameter("CompanyId")));
		companyList=companyDAO.findAll(Company.class);
		companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		return SUCCESS;
	}
	
	
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
	}

	public List<Company> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(List<Company> companyList) {
		this.companyList = companyList;
	}

	public List<CompanyType> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(List<CompanyType> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	public CompanyTypeDAO getCompanyTypeDAO() {
		return companyTypeDAO;
	}

	public void setCompanyTypeDAO(CompanyTypeDAO companyTypeDAO) {
		this.companyTypeDAO = companyTypeDAO;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	
}
