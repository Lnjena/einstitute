package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

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
	private Date birthDate;

	@Field
	private String birthPlace;

	@Field
	private String userId;

	@Field
	private String password;

	@Field
	private List<Identity> socialSecurityIds;

	@Field
	private ContactDetails contactDetails;

	public EntityHeader() {
	}

	public EntityHeader(String firstName, String lastName, ContactDetails contactDetails) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactDetails = contactDetails;
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

	public Date getBirthDate() {
		return birthDate;
	}

	public String getBirthPlace() {
		return birthPlace;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public List<Identity> getSocialSecurityIds() {
		return socialSecurityIds;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}
}
