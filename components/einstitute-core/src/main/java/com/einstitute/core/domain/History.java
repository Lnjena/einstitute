package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class History implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1834650455143570519L;
	
	@Field("chng_date")
	private Date changeDate; 
	
	@Field("chng_desc")
	private String changeDescription;

	public History(Date changeDate, String changeDescription) {
		super();
		this.changeDate = changeDate;
		this.changeDescription = changeDescription;
	}
	
}
