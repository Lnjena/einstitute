package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

public abstract class Inventory implements Serializable {
	
	public enum InventoryType {LIBRARY, CANTEEN, RETAIL};
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6352466589284848156L;
		
	@Id
	@Field("item_ref_code")
	private String itemRefCode;
	
	@Field("item_avlbl_quantity")
	private int quantityAvailable;
	
	@Field("item_unit_price")
	private double unitPrice;
	
	@Field("item_details")
	private ItemDetails itemDetails;
	
	@Field("item_hist")
	@DBRef(lazy=true)
	private List<History> changeHistory;

	public Inventory(String itemRefCode, int quantityAvailable,
			double unitPrice, ItemDetails itemDetails) {
		super();
		this.itemRefCode = itemRefCode;
		this.quantityAvailable = quantityAvailable;
		this.unitPrice = unitPrice;
		this.itemDetails = itemDetails;
	}	
	
}
