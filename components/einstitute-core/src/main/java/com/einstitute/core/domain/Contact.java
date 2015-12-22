package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -620836308243258681L;
	
	public enum Type {PHONE, MOBILE, EMAIL, FAX, FACE_BOOK, TWITTER};
	
	@Field
	private Type type;
	
	@Field
	private String details;
	
	@Field
	private boolean defaultContact;

	public Type getType() {
		return type;
	}

	public String getDetails() {
		return details;
	}

	public boolean isDefaultContact() {
		return defaultContact;
	}
}
