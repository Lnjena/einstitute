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
public class AdditionalDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280553745324006957L;
	
	@Field("addresses")
	List<Address> addresses;

	@Field("contacts")
	private List<Contact> contacts;
	
	

}
