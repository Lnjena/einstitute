package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="profile")
public class EntityProfile implements Serializable {

	private static final long serialVersionUID = -9002057856319879887L;
	
	@NotNull
	@Field("_id")
	@Id
	private String profileId;
	
	@Field
	private ExtraPersonalDetails extraPersonalDetails; 
	
	@Field
	private List<Entity> guarantors;
	
	@Field
	private List<Address> addresses;
	
	@Field
	private List<Contact> contacts;
	
	@Field
	private List<AcademicDetail> academics;
	
	@Field
	private List<Identity> identities;
	
	@Field
	private String firstName;
	
	@Field
	private String middleName;
	
	@Field
	private String lastName;
	
	@Field
	private String birthDate;

	
	public EntityProfile() {}

	public EntityProfile(String profileId, List<Address> addresses,
			List<Contact> contacts, String firstName, String middleName,
			String lastName, String birthDate) {
		super();
		this.profileId = profileId;
		this.addresses = addresses;
		this.contacts = contacts;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
	}

	public String getProfileId() {
		return profileId;
	}

	public ExtraPersonalDetails getExtraPersonalDetails() {
		return extraPersonalDetails;
	}

	public List<Entity> getGuarantors() {
		return guarantors;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}

	public List<AcademicDetail> getAcademics() {
		return academics;
	}

	public List<Identity> getIdentities() {
		return identities;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getBirthDate() {
		return birthDate;
	}
}
