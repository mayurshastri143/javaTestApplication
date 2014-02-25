package com.vaannila.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.City;
import com.vaannila.domain.Company;

public class CompanyDAOImpl extends GenericDAOImpl<Company, Long> implements CompanyDAO{

	@SessionTarget
	Session session;

	@TransactionTarget
	Transaction transaction;

	@SuppressWarnings("unchecked")
	@Override
	public List<Company> listCompanyByCompanyTypeId(int companyTypeId){
		List<Company> courses = null;
		try{
			Query query = session.createQuery("from Company where CompanyTypeId = :CompanyTypeId ");
			query.setParameter("CompanyTypeId", companyTypeId);
			courses = query.list();
		}catch(Exception e){
			e.printStackTrace();
		}
		return courses;
	}
}
