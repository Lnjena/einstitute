package com.einstitute.core.domain;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Field;

public class Identity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1932947442074280041L;
	
	@Field("soc_id")
	private String id;
	
	@Field("soc_id_type")
	private String idType;
	
	@Field("soc_id_person_name")
	private String personName;
	
	@Field("soc_id_issue_auth")
	private String issueAuthority;
	

	@Field("soc_id_issue_date")
	private LocalDate issueDate;
	
	@Field("soc_id_exp_date")
	private LocalDate expiryDate;
	
	@Field("soc_id_country_code")
	private String countryCode;

	public String getId() {
		return id;
	}

	public String getIdType() {
		return idType;
	}

	public String getPersonName() {
		return personName;
	}

	public String getIssueAuthority() {
		return issueAuthority;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public String getCountryCode() {
		return countryCode;
	}
}
