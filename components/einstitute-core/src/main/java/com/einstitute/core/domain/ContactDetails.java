/**
 * 
 */
package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author 502400119
 *
 */
public class ContactDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280553745324006957L;
	
	@Field
	List<Address> addresses;

	@Field
	private List<Contact> contacts;
	
	public ContactDetails(){
	}

	public ContactDetails(List<Address> addresses, List<Contact> contacts) {
		this.addresses = addresses;
		this.contacts = contacts;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public List<Contact> getContacts() {
		return contacts;
	}
	
}
