package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "discount")
public class Discount implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7686194689891094146L;

	@Id
	private ObjectId _id;
	@Field("dct_desc")
	private String description;
	@Field("dct_amt")
	private Double amount;
	@Field("dct_prcent")
	private Double percentage;
	@Field("dct_start_date")
	private Date startDate;
	@Field("dct_end_date")
	private Date endDate;

	public Discount(String description, Double amount, Double percentage, Date startDate, Date endDate) {
		this.description = description;
		this.amount = amount;
		this.percentage = percentage;
		this.startDate = startDate;
		this.endDate = endDate;
	}


	public ObjectId get_id() {
		return _id;
	}

	public String getDescription() {
		return description;
	}

	public Double getAmount() {
		return amount;
	}

	public Double getPercentage() {
		return percentage;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

}
