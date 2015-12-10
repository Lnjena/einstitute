package com.einstitute.core.domain;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="library")
public class LibraryInventory extends Inventory {
	
	public LibraryInventory(String itemRefCode, int quantityAvailable,
			double unitPrice,
			BookDetails itemDetails) {
		super(itemRefCode, quantityAvailable, unitPrice, itemDetails);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2023900029811136916L;

	
}
