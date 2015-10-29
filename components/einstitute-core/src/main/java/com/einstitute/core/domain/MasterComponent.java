package com.einstitute.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mstr_component")
public class MasterComponent {
	
	@Id
	private String _id;
	
	private String uri;

	public MasterComponent(String _id, String uri) {
		super();
		this._id = _id;
		this.uri = uri;
	}

	public String get_id() {
		return _id;
	}

	public String getUri() {
		return uri;
	}
	
}
