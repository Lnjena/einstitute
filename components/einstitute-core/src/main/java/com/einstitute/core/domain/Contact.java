package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -620836308243258681L;
	
	public enum Type {PHONE, MOBILE, EMAIL, FAX, FACE_BOOK, TWITTER};
	
	@Field("cont_type")
	private Type type;
	
	@Field("cont_category")
	private String category;
	
	@Field("cont_details")
	private String details;
	
	@Field("cont_default")
	private boolean defaultContact;

}
