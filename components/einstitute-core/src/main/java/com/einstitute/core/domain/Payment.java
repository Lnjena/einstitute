package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "payment")
public class Payment implements Serializable {

	private static final long serialVersionUID = -9094521697902182892L;

	@Id
	private ObjectId _id;
	@Field("payment_desc")
	private String description;
	@Field("start_date")
	private Date startDate;
	@Field("end_date")
	private Date endDate;
	@Field("payment_comps")
	private List<PaymentComponent> paymentComponents;

	public Payment(String description, Date startDate, Date endDate) {
		super();
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.paymentComponents = new ArrayList<PaymentComponent>();
	}

	public ObjectId get_id() {
		return _id;
	}

	public String getDescription() {
		return description;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setPaymentComponents(List<PaymentComponent> paymentComponents) {
		this.paymentComponents = paymentComponents;
	}

	public List<PaymentComponent> getPaymentComponents() {
		return paymentComponents;
	}
}
