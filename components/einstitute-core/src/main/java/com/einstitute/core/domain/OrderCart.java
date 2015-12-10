package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="order")
public class OrderCart implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1527040235108279871L;
	
	
	public enum Status {CART_DORMANT, CART_OPEN, CART_CANCELLED, ORDER_OPEN, ORDER_PROCESSING, ORDER_TRANSPORTING, ORDER_DELIVERED, ORDER_CANCELLED, ORDER_CLOSED};
	
	@Id
	private ObjectId _id;
	
	@Field("order_date")
	private Date orderDate;
	
	@Field("order_by")
	@DBRef
	private Entity orderedBy;
	
	//@DBRef
	@Field("order_items")
	private List<InventoryItem> items;
	
	@Field("order_status")
	private Status status;
	
	

	public OrderCart(Entity orderedBy) {
		super();
		this.orderedBy = orderedBy;
		this.orderDate = new Date();
		this.status = Status.CART_OPEN;
		this.items = new ArrayList<InventoryItem>();
	}

	public Status getStatus() {
		return status;
	}

	public boolean add(InventoryItem e) {
		return items.add(e);
	}

	public void clear() {
		items.clear();
	}

	public boolean contains(InventoryItem o) {
		return items.contains(o);
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

	public Iterator<InventoryItem> iterator() {
		return items.iterator();
	}

	public boolean remove(Inventory o) {
		return items.remove(o);
	}

	public boolean removeAll(Collection<Inventory> c) {
		return items.removeAll(c);
	}

	public int size() {
		return items.size();
	}
}
