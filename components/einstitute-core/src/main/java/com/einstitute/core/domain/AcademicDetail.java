package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class AcademicDetail implements Serializable {

	private static final long serialVersionUID = -8940973429007721699L;
	
	@Field
	private String qualification;
	
	@Field
	private String institute;
	
	@Field
	private String grade;
	
	@Field
	private Integer year;

	
	public AcademicDetail(String qualification, String institute,
			String grade, Integer year) {
		super();
		this.qualification = qualification;
		this.institute = institute;
		this.grade = grade;
		this.year = year;
	}

	public AcademicDetail(){}
	
	public String getQualification() {
		return qualification;
	}

	public String getInstitute() {
		return institute;
	}

	public String getGrade() {
		return grade;
	}

	public Integer getYear() {
		return year;
	}
}
