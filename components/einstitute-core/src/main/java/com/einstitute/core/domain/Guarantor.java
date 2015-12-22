package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class Guarantor implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 430083537504286456L;

	private enum Relation {FATHER, MOTHER, GUARDIAN};
	
	@DBRef(lazy=true)
	private Entity refEntity; 
	
	@Field
	private Relation relation;
		
	@Field
	private boolean primary;

	public Entity getRefEntity() {
		return refEntity;
	}

	public Relation getRelation() {
		return relation;
	}

	public boolean isPrimary() {
		return primary;
	}
}
