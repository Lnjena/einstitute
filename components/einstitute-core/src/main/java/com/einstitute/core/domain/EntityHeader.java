package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonCreator;

public class EntityHeader implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1660974523325465826L;
	
	@Field
	private String firstName;
	
	@Field
	private String lastName;
	
	@Field
	private String middleName;
	
	@Field
	private List<Identity> socialSecurityIds; 
	
	@Field
	private String userId;
	
	@Field
	private String password;
	
	public EntityHeader(){}

	public EntityHeader(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public List<Identity> getSocialSecurityIds() {
		return socialSecurityIds;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}
	
}
