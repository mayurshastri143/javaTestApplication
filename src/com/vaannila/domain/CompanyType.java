package com.vaannila.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity(name="companyType")
public class CompanyType {
	
	@Id
	@GeneratedValue
	@Column(name="CompanyTypeId")
	private int CompanyTypeId;
	
	@Column(name="CompanyTypeName")
	private String CompanyTypeName;
	
	@Column(name="IsActive")
	private Boolean IsActive;

	public int getCompanyTypeId() {
		return CompanyTypeId;
	}

	public void setCompanyTypeId(int companyTypeId) {
		CompanyTypeId = companyTypeId;
	}

	public String getCompanyTypeName() {
		return CompanyTypeName;
	}

	public void setCompanyTypeName(String companyTypeName) {
		CompanyTypeName = companyTypeName;
	}

	public Boolean getIsActive() {
		return IsActive;
	}

	public void setIsActive(Boolean isActive) {
		IsActive = isActive;
	}
	
	

}
