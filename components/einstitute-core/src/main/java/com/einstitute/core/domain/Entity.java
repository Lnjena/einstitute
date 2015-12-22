package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonCreator;

@Document(collection="entity")
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048909041066151311L;

	@NotNull
	@Id
	private String _id;	
	
	@NotNull
	@Field
	private String entityType;
	
	@NotNull
	@DBRef(lazy=true)
	private Organisation organisation;
	
	@NotNull
	@Field
	private EntityHeader entityHeader;
	
	@NotNull
	@DBRef(lazy=true)
	private List<Guarantor> guarantors;
	
	@NotNull
	@Field
	private ContactDetails contactDetails;
	
	@NotNull
	@Field
	private ExtraPersonalDetails extraPersonalDetails;
	
	@DBRef(lazy=true)
	private Wallet wallet;
	
	public Entity() {}

	public Entity(String _id, String entityType, String orgCode, 
			String firstName, String lastName) {
		super();
		this._id = _id;
		this.entityType = entityType;
		this.organisation = new Organisation(orgCode);
		this.entityHeader = new EntityHeader(firstName, lastName);
	}
	
	public Entity(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return _id;
	}

	public String getEntityType() {
		return entityType;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

	public EntityHeader getEntityHeader() {
		return entityHeader;
	}

	public List<Guarantor> getGuarantors() {
		return guarantors;
	}

	public ContactDetails getContactDetails() {
		return contactDetails;
	}

	public ExtraPersonalDetails getExtraPersonalDetails() {
		return extraPersonalDetails;
	}

	public Wallet getWallet() {
		return wallet;
	}
}
