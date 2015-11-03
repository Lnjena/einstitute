package com.einstitute.core.domain.schedule;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class Frequency implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -712191676660986182L;

	@Field("freq_type")
	private FrequencyType frequencyType;
	
	@Field("interval")
	private Integer interval;
	
	@Field("on_days")
	private FrequencyType.DaysOfWeek[] onDays;
	
	@Field("on_dates")
	private int[] onDates;
	
	@Field("on_months")
	private FrequencyType.MonthsOfYear[] onMonths;
	
	public Frequency(FrequencyType frequencyType, int interval) {
		super();
		this.frequencyType = frequencyType;
		this.interval = interval;
	}
	
	public Frequency(FrequencyType.DaysOfWeek ... onDays) {
		super();
		this.frequencyType = FrequencyType.ON_DAYS;
		this.onDays = onDays;
	}
	
	public Frequency(int ... onDates) {
		this.frequencyType = FrequencyType.ON_DATES;
		this.onDates = onDates;
	}
	
	public Frequency(FrequencyType.MonthsOfYear ... onMonths) {
		this.frequencyType = FrequencyType.ON_MONTHS;
		this.onMonths = onMonths;
	}
	
	public Frequency(FrequencyType frequencyType) {
		super();
		this.frequencyType = frequencyType;
	}
}
