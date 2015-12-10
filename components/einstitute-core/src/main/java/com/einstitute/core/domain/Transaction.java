package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="transaction")
public class Transaction implements Serializable {

	public enum Type {DEBIT, CREDIT};
	public enum Status {CLEARING, PROCESSING, FAILED, SUCCESS};
	public enum Medium {WALLET_TRANSFER, CREDIT_CARD, ONLINE_BANKING, MANUAL_TRANSFER};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1858817682722692308L;
	
	//@Id
	//private ObjectId _id;
	
	@Id
	@Field("trans_ref_code")
	private String refCode;
	
	@Field("trans_amnt")
	private double amount;
	
	@Field("trans_type")
	private Type type;
	
	@Field("trans_start_date")
	private Date startDate;
	
	@Field("trans_end_date")
	private Date endDate;
	
	@Field("trans_status")
	private Status status;
	
	public void setStatus(Status status) {
		this.status = status;
	}

	@Field("trans_medium")
	private Medium medium;
	
	@Field("trans_desc")
	private String decription;
	
	@Field("trans_hist")
	private List<History> transactionHistory;

	public boolean addHistory(History e) {
		return transactionHistory.add(e);
	}

	public Transaction(String refCode, double amount, Type type,
			Medium medium, Status status, String decription, List<History> transactionHistory) {
		super();
		this.refCode = refCode;
		this.amount = amount;
		this.type = type;
		this.medium = medium;
		this.decription = decription;
		this.startDate = new Date();
		this.endDate = new Date();
		this.status = status;
		this.transactionHistory = transactionHistory;
	}

	public String getRefCode() {
		return refCode;
	}

	public double getAmount() {
		return amount;
	}

	public Type getType() {
		return type;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Status getStatus() {
		return status;
	}

	public Medium getMedium() {
		return medium;
	}

	public String getDecription() {
		return decription;
	}

}
