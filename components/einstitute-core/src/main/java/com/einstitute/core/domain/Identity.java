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

	public Identity(String id, String idType, String personName, String issueAuthority, LocalDate issueDate, LocalDate expiryDate,
			String countryCode) {
		super();
		this.id = id;
		this.idType = idType;
		this.personName = personName;
		this.issueAuthority = issueAuthority;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
		this.countryCode = countryCode;
	}
	
}
