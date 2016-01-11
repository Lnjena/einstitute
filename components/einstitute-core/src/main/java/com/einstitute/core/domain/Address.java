package com.einstitute.core.domain;

import java.io.Serializable;

import org.joda.time.DateTime;
import org.springframework.data.mongodb.core.mapping.Field;

public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3120767729546181310L;
	
	public enum AddressType {HOME, RESIDENTIAL, BUSINESS, PERMANENT, RENTED, OFFICE, };
	
	@Field
	private AddressType type;
	
	@Field
	private String line1;
	
	@Field
	private String line2;
	
	@Field
	private String line3;
	
	@Field
	private String city;
	
	@Field
	private String province;
	
	@Field
	private String countryCode;
	
	@Field
	private String postCode;	
	
	@Field
	private DateTime dateCreated;
	
	public Address(){
	}
	
	public Address(AddressType type, String line1, String line2, String line3, String city,
			String province, String countryCode, String postCode) {
		super();
		this.type = type;
		this.line1 = line1;
		this.line2 = line2;
		this.line3 = line3;
		this.city = city;
		this.province = province;
		this.countryCode = countryCode;
		this.postCode = postCode;
		this.dateCreated = new DateTime();
	}

	public AddressType getType() {
		return type;
	}

	public String getLine1() {
		return line1;
	}

	public String getLine2() {
		return line2;
	}

	public String getLine3() {
		return line3;
	}

	public String getCity() {
		return city;
	}

	public String getProvince() {
		return province;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public String getPostCode() {
		return postCode;
	}

	public DateTime getDateCreated() {
		return dateCreated;
	}
}
