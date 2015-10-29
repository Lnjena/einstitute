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
	
	@DBRef
	private List<Entity> children;;
	
	@DBRef
	private Entity parent;

	public Entity(String _id, String entityType, String orgCode) {
		super();
		this._id = _id;
		this.entityType = entityType;
		this.orgCode = orgCode;
	}
	
	
	public String get_id() {
		return _id;
	}



	public String getEntityType() {
		return entityType;
	}



	public String getOrgCode() {
		return orgCode;
	}



	public EntityPermission getPermission() {
		return permission;
	}



	@Transient
	private EntityPermission permission;
}
