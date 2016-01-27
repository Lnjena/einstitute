package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="entity")
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048909041066151311L;

	@NotNull
	@Id
	@Field("_id")
	private String userId;	
	
	@NotNull
	@Field
	private String entityType;
	
	@NotNull
	@DBRef(lazy=true)
	private Organisation organisation;
	
	@DBRef(lazy=true)
	private List<Guarantor> guarantors;
	
	@NotNull
	@Field
	private ExtraPersonalDetails extraPersonalDetails;
	
	@Field
	private List<Address> addresses;
	
	private List<AcademicDetail> academics;
	
	private List<Identity> identities;
	
	@DBRef(lazy=true)
	private Wallet wallet;
	
	public Entity() {}

	public Entity(String userId, String entityType, String orgCode,ContactDetails contactDetails,
			String firstName, String lastName) {
		super();
		this.userId = userId;
		this.entityType = entityType;
		this.organisation = new Organisation(orgCode);
	}
	
	public Entity(String userId) {
		this.userId=userId;
	}
	
	public String getUserId() {
		return userId;
	}

	public String getEntityType() {
		return entityType;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public List<Guarantor> getGuarantors() {
		return guarantors;
	}

	public ExtraPersonalDetails getExtraPersonalDetails() {
		return extraPersonalDetails;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<AcademicDetail> getAcademics() {
		return academics;
	}

	public List<Identity> getIdentities() {
		return identities;
	}

	public Wallet getWallet() {
		return wallet;
	}

}
