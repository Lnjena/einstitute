package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "user")
public class User implements Serializable {

	private static final long serialVersionUID = -3370981650606424867L;

	@Id
	@Field("_id")
	private String userId;
	@Field
	private String password;
	@Field
	private String firstName;
	@Field
	private String middlename;
	@Field
	private String lastName;
	@Field
	private Date birthDate;
	@Field
	private String email;
	@Field
	private String mobile;

	public User() {
	}

	public User(String userId, String password, String firstName,
			String middlename, String lastName, Date birthDate, String email,
			String mobile) {

		this.userId = userId;
		this.password = password;
		this.firstName = firstName;
		this.middlename = middlename;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.email = email;
		this.mobile = mobile;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getLastName() {
		return lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public String getEmail() {
		return email;
	}

	public String getMobile() {
		return mobile;
	}
}
