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
	
	@Field("addr_type")
	private AddressType type;
	
	@Field("addr_line_1")
	private String line1;
	
	@Field("addr_line_2")
	private String line2;
	
	@Field("addr_line_3")
	private String line3;
	
	@Field("addr_city")
	private String city;
	
	@Field("addr_province")
	private String province;
	
	@Field("addr_country")
	private String countryCode;
	
	@Field("addr_post_code")
	private String postCode;	
	
	@Field("addr_created_on")
	private DateTime dateCreated;

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

}
