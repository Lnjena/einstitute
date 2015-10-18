package com.einstitute.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="ENTITY")
public class Entity {
	
	@Id
	private Long entityId;	
	private String entityType;
}
