package com.einstitute.core.domain;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

public class AttendanaceReport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3778563213099524960L;
	
	@Field("entity_id")
	private String entityId;
	@Field("attnd_status")
	private String attendanceStatus;
	
	public AttendanaceReport(String entityId, String attendanceStatus) {
		super();
		this.entityId = entityId;
		this.attendanceStatus = attendanceStatus;
	}

	public String getEntityId() {
		return entityId;
	}

	public String getAttendanceStatus() {
		return attendanceStatus;
	}	
	
}

