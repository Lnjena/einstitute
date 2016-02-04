package com.einstitute.core.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="organisation")
public class Organisation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3079687803842600457L;
	
	@NotNull
	@Id
	private String _id;
	
	@Field
	private String name;
	
	@DBRef(lazy=true)
	private Entity owner;
	
	@Field
	private String parentOrgCode;
			
	@Field
	private boolean active;
	
	public Organisation(){}

	public Organisation(String _id, String name, String ownerEntId, String parentOrgCode) {
		this._id = _id;
		this.name = name;
		//this.owner = new Entity(_id);
		this.parentOrgCode = parentOrgCode;
		this.active = true;
	}

	public Organisation(String _id) {
		this._id = _id;
	}

	public String get_id() {
		return _id;
	}

	public String getName() {
		return name;
	}

	public Entity getOwner() {
		return owner;
	}

	public String getParentOrgCode() {
		return parentOrgCode;
	}

	public boolean isActive() {
		return active;
	}
}
