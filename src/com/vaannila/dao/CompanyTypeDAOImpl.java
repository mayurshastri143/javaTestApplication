package com.vaannila.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;
import com.vaannila.domain.CompanyType;
import com.vaannila.domain.Council;


public class CompanyTypeDAOImpl extends GenericDAOImpl<CompanyType, Long> implements CompanyTypeDAO {

	@Override
	public CompanyType selectCompanyType(String CompanyTypeName) {
		CompanyType companyType=null;
		System.out.println("user input:"+CompanyTypeName);
		String sql = "SELECT c FROM companyType c WHERE c.CompanyTypeName= :CompanyTypeName";
        Query query = session.createQuery(sql).setParameter("CompanyTypeName", CompanyTypeName);
        companyType = findOne(query);
//  
//		List result = session.createQuery("select c from CompanyType as c where c.companyTypeName='"+companyTypeName+"'").list();  
//		if (result.size() == 1){
//            return (CompanyType) result.get(0);
//        }
        return companyType;
	}
}
