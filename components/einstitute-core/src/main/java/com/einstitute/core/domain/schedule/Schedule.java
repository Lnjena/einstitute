package com.einstitute.core.domain.schedule;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

//@Document(collection="schedule")
public class Schedule implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1787007085487221239L;
	
	//@Id
	//private ObjectId _id;
	
	@Field("frequency")
	private Frequency frequency;
	
	@Field("last_run_date")
	private Date lastRunDate;
	
	@Field("next_run_date")
	private Date nextRunDate;
	
	@Field()
	private int precision;

	
	public Schedule(Frequency frequency) {
		this.frequency = frequency;
		this.lastRunDate = new Date();
		this.nextRunDate = getNextRunDate(frequency, lastRunDate);
		this.precision = 24 * 60;
	}
	
	public Schedule(Frequency frequency, Date lastRunDate, Date nextRunDate,
			int precision) {
		super();
		this.frequency = frequency;
		this.lastRunDate = lastRunDate;
		this.nextRunDate = nextRunDate;
		this.precision = precision;
	}
	
	public static Date getNextRunDate(Frequency frequency, Date lastRunDate) {
		return new Date();
	}
}
