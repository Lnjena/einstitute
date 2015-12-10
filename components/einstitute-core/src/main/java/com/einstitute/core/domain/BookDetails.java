package com.einstitute.core.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class BookDetails extends ItemDetails {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7503145671811475943L;
	
	
	@Field("book_title")
	private String title;
	@Field("book_author")
	private String author;
	@Field("book_publisher")
	private String publisher;
	@Field("book_pub_date")
	private Date publicationDate;
	
	public BookDetails(String title, String author, String publisher,
			Date publicationDate) {
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.publicationDate = publicationDate;
	}
}
