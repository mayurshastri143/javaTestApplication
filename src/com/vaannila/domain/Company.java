/**
 * 
 */
package com.vaannila.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Pirate
 *
 */

@Entity
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue
	@Column(name="CompanyId")
	private int CompanyId;
	
	@Column(name="CompanyName")
	private String CompanyName;
	
	@ManyToOne
	@JoinColumn(name="CompanyTypeId", referencedColumnName="CompanyTypeId")
	private CompanyType companyType;
	
	@Column(name="IsMain")
	private int isMain;
	
	public int getCompanyId() {
		return CompanyId;
	}

	public void setCompanyId(int companyId) {
		CompanyId = companyId;
	}

	public String getCompanyName() {
		return CompanyName;
	}

	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}

	public CompanyType getCompanyType() {
		return companyType;
	}

	public void setCompanyType(CompanyType companyType) {
		this.companyType = companyType;
	}

	public int getIsMain() {
		return isMain;
	}

	public void setIsMain(int isMain) {
		this.isMain = isMain;
	}
}
