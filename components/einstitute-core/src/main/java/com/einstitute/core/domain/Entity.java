package com.einstitute.core.domain;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "entity")
public class Entity implements Serializable {

	private static final long serialVersionUID = 6048909041066151311L;

	@NotNull
	@Id
	@Field("_id")
	private String entityId;

	@Field
	private String orgCode;

	@Field
	private String profileId;

	@Field
	private EntityProfile profile;

	@NotNull
	@Field
	private String entityType;

	@Field
	private Boolean active;

	@NotNull
	@DBRef(lazy = true)
	private Organisation organisation;

	public Entity() {
	}

	public Entity(String entityId, String orgCode, String profileId,
			EntityProfile profile, String entityType, Boolean active) {
		super();
		this.entityId = entityId;
		this.orgCode = orgCode;
		this.profileId = profileId;
		this.profile = profile;
		this.entityType = entityType;
		this.active = active;
	}

	public String getEntityId() {
		return entityId;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public String getProfileId() {
		return profileId;
	}

	public EntityProfile getProfile() {
		return profile;
	}

	public String getEntityType() {
		return entityType;
	}

	public Boolean getActive() {
		return active;
	}

	public Organisation getOrganisation() {
		return organisation;
	}

}
