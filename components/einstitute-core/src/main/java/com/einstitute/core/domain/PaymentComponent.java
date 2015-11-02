package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class PaymentComponent implements Serializable {

	private static final long serialVersionUID = -2390446572726709081L;

	@Field("payment_comp_desc")
	private String description;
	@Field("payment_comp_amount")
	private Double amount;
	@Field("payment_comp_discounts")
	private List<Discount> paymentDiscounts;

	public PaymentComponent(String description, Double amount) {
		super();
		this.description = description;
		this.amount = amount;
		this.paymentDiscounts = new ArrayList<Discount>();
	}

	public String getDescription() {
		return description;
	}

	public Double getAmount() {
		return amount;
	}

	public void setPaymentDiscounts(List<Discount> paymentDiscounts) {
		this.paymentDiscounts = paymentDiscounts;
	}
	
	public List<Discount> getPaymentDiscounts() {
		return paymentDiscounts;
	}
}
