package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public class InventoryItem implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -49819221588542173L;
	
	@Field("order_item")
	@DBRef
	private Inventory item;
	
	@Field("order_qnty")
	private int units;

	public InventoryItem(Inventory item, int units) {
		super();
		this.item = item;
		this.units = units;
	}
	
}
