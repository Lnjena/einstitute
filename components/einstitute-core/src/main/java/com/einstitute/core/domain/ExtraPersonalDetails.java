package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class ExtraPersonalDetails implements Serializable {
	
	private enum Religion {HINDU, MUSLIM, CHRISTIAN, BDHISM, SIKH, JAIN, JEWS, PARSI};
	
	private enum Caste {GENERAL, SC, ST, OBC};
	
	private enum Nationality {INDIAN}; 

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280553745324006957L;
	
	@Field
	private Religion religion;
	
	@Field
	private Caste caste;
	
	@Field
	private String subCaste;
	
	@Field
	private Nationality nationality;

}
