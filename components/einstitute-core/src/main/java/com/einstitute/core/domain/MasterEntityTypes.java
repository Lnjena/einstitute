package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="mstr_ent_types")
public class MasterEntityTypes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6847123677837109818L;
	
	
	@Id
	private String _id;
	
	@Field("desc")
	private String description;

	public MasterEntityTypes(String _id, String description) {
		super();
		this._id = _id;
		this.description = description;
	}

	public String get_id() {
		return _id;
	}

	public String getDescription() {
		return description;
	}
}
