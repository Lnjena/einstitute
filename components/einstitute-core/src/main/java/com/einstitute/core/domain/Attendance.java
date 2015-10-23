package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="attendance")
public class Attendance implements Serializable {
	
	private static final Logger LOGGER = Logger.getLogger(Attendance.class);
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2649707086733051087L;

	@Id
	private AttendanceId _id;
		
	
	@Field("attnd_report")
	private List<AttendanaceReport> attendanaceReport;

	@PersistenceConstructor
	public Attendance(@Value("_id.group_id") String groupId, @Value("_id.grp_owner_id") String ownerId, @Value("_id.grp_activity_id") String activityId, 
			@Value("_id.act_start_date")Date activityStartDate, @Value("_id.act_end_date")Date activityEndDate, @Value("attnd_report")List<AttendanaceReport> attendanaceReport) {
		super();		
		this._id = new AttendanceId(groupId, activityId, ownerId, activityStartDate, activityEndDate);		
		this.attendanaceReport = attendanaceReport;
		//LOGGER.info("##########attendanaceReport######" + attendanaceReport.size());
	}
	
	public Attendance registerAttendance(String entityId, String attendanceStatus) {
		this.attendanaceReport.add(new AttendanaceReport(entityId, attendanceStatus));
		
		return this;
	}

	public AttendanceId get_id() {
		return _id;
	}
	
	public List<AttendanaceReport> getAttendanaceReport() {
		return attendanaceReport;
	}	
}
