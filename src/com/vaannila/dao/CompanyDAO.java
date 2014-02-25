/**
 * 
 */
package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.City;
import com.vaannila.domain.Company;

/**
 * @author Pirate
 *
 */
public interface CompanyDAO extends GenericDAO<Company, Long>{

	public List<Company> listCompanyByCompanyTypeId(int companyTypeId);

}
