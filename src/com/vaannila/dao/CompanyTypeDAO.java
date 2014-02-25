package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.CompanyType;

public interface CompanyTypeDAO extends GenericDAO<CompanyType, Long> {
	public CompanyType selectCompanyType(String companyTypeName);
}
