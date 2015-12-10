package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="entity")
public class Entity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6048909041066151311L;

	@Id
	private String _id;	
	
	@Field("ent_type")
	private String entityType;
	
	@Field("org_code")
	private String orgCode;
	
	@Field("ent_header")
	private EntityHeader entityHeader;
	
	@DBRef(lazy=true)
	private List<Entity> children;;
	
	@DBRef(lazy=true)
	private Entity parent;
	
	@DBRef(lazy=true)
	private Entity guardians;
	
	@DBRef(lazy=true)
	private Wallet wallet;
	
	@Field("ent_addl_details")
	private AdditionalDetails additionalDetails;

		
	public Entity(String _id, String entityType, 
			String orgCode, EntityHeader entityHeader, 
				Entity parent, AdditionalDetails additionalDetails) {
		super();
		this._id = _id;
		this.entityType = entityType;
		this.entityHeader = entityHeader;
		this.parent = parent;
		this.additionalDetails = additionalDetails;
	}

	public String get_id() {
		return _id;
	}

	public EntityPermission getPermission() {
		return permission;
	}


	public String getEntityType() {
		return entityType;
	}

	@Transient
	private EntityPermission permission;
}
