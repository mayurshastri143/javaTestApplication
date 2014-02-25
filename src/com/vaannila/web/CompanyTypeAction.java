package com.vaannila.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vaannila.dao.CompanyTypeDAO;
import com.vaannila.dao.CompanyTypeDAOImpl;
import com.vaannila.domain.CompanyType;

public class CompanyTypeAction extends ActionSupport implements ModelDriven<CompanyType>{

	private CompanyType companyType= new CompanyType();
	private CompanyTypeDAO companyTypeDAO=new CompanyTypeDAOImpl();
	private List<CompanyType> companyTypeList=new ArrayList<CompanyType>();
	/**
	 * 
	 */
	private static final long serialVersionUID = 4590566973878742885L;

	@Override
	public CompanyType getModel() {
		// TODO Auto-generated method stub
		return companyType;
	}

	public String saveOrUpdate()
	{	
		if(companyType.getCompanyTypeName()==null){
			return SUCCESS;	
		}else{
			companyTypeDAO.save(companyType);
			return SUCCESS;
		}
	}
	
	public String list(){
		companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		return SUCCESS;
	}
	
	public String edit(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		companyType = companyTypeDAO.findByID(CompanyType.class, Integer.parseInt(request.getParameter("companyTypeId")));
		companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		return SUCCESS;
	}
	
	public String delete(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		companyTypeDAO.delete(companyType);
		companyTypeList=companyTypeDAO.findAll(CompanyType.class);
		return SUCCESS;
	}
	
	public String search(){
		HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);
		companyType=companyTypeDAO.selectCompanyType(request.getParameter("companyTypeName"));
		System.out.println(companyType.getCompanyTypeName());
		return SUCCESS;
	}
	
	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public CompanyTypeDAO getCompanyTypeDAO() {
		return companyTypeDAO;
	}

	public void setCompanyTypeDAO(CompanyTypeDAO companyTypeDAO) {
		this.companyTypeDAO = companyTypeDAO;
	}

	public List<CompanyType> getCompanyTypeList() {
		return companyTypeList;
	}

	public void setCompanyTypeList(List<CompanyType> companyTypeList) {
		this.companyTypeList = companyTypeList;
	}

	
}