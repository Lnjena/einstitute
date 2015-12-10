package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.einstitute.core.domain.Transaction.Status;
import com.einstitute.core.domain.Transaction.Type;

@Document(collection="wallet")
public class Wallet implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4210684867872272655L;
	
	/*@Id
	private ObjectId _id;*/
	
	@Id
	private String entityId;
	
	@Field("avlbl_amnt")
	private double availableAmount;
	
	@Field("as_of_date")
	private Date asOfDate;
	
	@Field("transactions")
	@DBRef(lazy=true)
	private List<Transaction> transactions;
	
	/*public Wallet(String entityId) {
		super();
		this.entityId = entityId;
		this.transactions = new ArrayList<Transaction>();
	}*/

	public  Wallet(String entityId, List<Transaction> transactions) {
		super();
		this.entityId = entityId;
		this.transactions = transactions;
	}
	
	public void addTransaction(Transaction transaction) {
		if(transaction.getStatus() != Status.SUCCESS) {
			  throw new IllegalArgumentException("Only Success Transactions can be addedd to Wallet");
		}
		this.availableAmount =  transaction.getType() == Type.CREDIT ? this.availableAmount + transaction.getAmount() : this.availableAmount - transaction.getAmount();
		this.transactions.add(transaction);
	}
}
