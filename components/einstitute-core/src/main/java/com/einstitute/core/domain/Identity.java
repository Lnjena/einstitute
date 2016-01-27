package com.einstitute.core.domain;

import java.io.Serializable;

import org.joda.time.LocalDate;
import org.springframework.data.mongodb.core.mapping.Field;

public class Identity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1932947442074280041L;
	
	@Field
	private String id;
	
	@Field
	private String idType;
	
	@Field
	private String personName;
	
	@Field
	private String issueAuthority;
	
	@Field
	private LocalDate issueDate;
	
	@Field
	private LocalDate expiryDate;
	
	@Field
	private String countryCode;

	
	public Identity() {
		super();
	}

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
