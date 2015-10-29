package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 471148894499066503L;

	@Field("uri")
	private String uri;
	
	@Field("perm_type")
	private PermissionType type;

	public Permission(String uri, PermissionType type) {
		super();
		this.uri = uri;
		this.type = type;
	}

	public String getUri() {
		return uri;
	}

	public PermissionType getType() {
		return type;
	}
	
}
