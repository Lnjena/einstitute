package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class EntityHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1660974523325465826L;
	
	@Field("first_name")
	private String firstName;
	
	@Field("last_name")
	private String lastName;
	
	@Field("middle_name")
	private String middleName;
	
	@Field("social_sec_ids")
	private List<Identity> socialSecurityIds; 
	
	@Field("usr_id")
	private String userId;
	
	@Field("usr_pass")
	private String password;

	public EntityHeader(String firstName, String lastName, String middleName, List<Identity> socialSecurityIds) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.socialSecurityIds = socialSecurityIds;
	}
	
	
}
