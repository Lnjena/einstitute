package com.einstitute.core.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="entity")
public class Entity {
	
	@Id
	private String entityId;	
	
	@Field("entType")
	private String entityType;
	
	@Field("defaultRoles")
	private List<String> defaultRoles;

	public String getEntityId() {
		return entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public String getEntityType() {
		return entityType;
	}

	public void setEntityType(String entityType) {
		this.entityType = entityType;
	}

	public List<String> getDefaultRoles() {
		return defaultRoles;
	}

	public void setDefaultRoles(List<String> defaultRoles) {
		this.defaultRoles = defaultRoles;
	}
	
	
}
