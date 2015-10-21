package com.einstitute.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "mstr_component")
public class MasterComponent {
	
	@Id
	private String uri;
	
	private String path;

	public MasterComponent(String uri, String path) {
		super();
		this.uri = uri;
		this.path = path;
	}

	public String getUri() {
		return uri;
	}

	public String getPath() {
		return path;
	}	
	
}
