package com.einstitute.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="canteen")
public class CanteenInventory extends Inventory {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3433540014802438258L;
	
	public CanteenInventory(String itemRefCode, int quantityAvailable,
			double unitPrice, CanteenItemDetails itemDetails) {
		super(itemRefCode, quantityAvailable, unitPrice, itemDetails);
	}
	
}
