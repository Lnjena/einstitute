package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3370981650606424867L;

	@Id
	@Field("_id")
	private String userId;
	@Field
	private String password;
	@Field
	private String entityId;
	@Field
	private Entity entity;
	@Field
	private List<String> assignableEntities;
	@Field
	private String tempAuthCode;

	public User() {
	}

	public User(String userId, String password, String entityId, Entity entity) {

		this.userId = userId;
		this.password = password;
		this.entityId = entityId;
		this.entity = entity;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getEntityId() {
		return entityId;
	}

	public Entity getEntity() {
		return entity;
	}

	public List<String> getAssignableEntities() {
		return assignableEntities;
	}

	public String getTempAuthCode() {
		return tempAuthCode;
	}
}
