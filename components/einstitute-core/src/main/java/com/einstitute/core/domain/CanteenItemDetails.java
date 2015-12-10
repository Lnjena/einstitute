package com.einstitute.core.domain;

import org.springframework.data.mongodb.core.mapping.Field;

public class CanteenItemDetails extends ItemDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4398442928635505412L;
	
	@Field("item_desc")
	private String itemDescription;
	
	@Field("item_ingredients")
	private String ingredients;
	
	public CanteenItemDetails(String itemDescription, String ingredients) {
		super();
		this.itemDescription = itemDescription;
		this.ingredients = ingredients;
	}
	
}
