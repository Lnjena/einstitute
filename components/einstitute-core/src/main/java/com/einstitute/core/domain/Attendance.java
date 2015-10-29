package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.data.annotation.Id;
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
	private String _id;
	
	@Field("grp_id")
	private String groupId;
	@Field("grp_activity_id")
	private String activityId;
	@Field("grp_owner_id")
	private String ownerId;
	
	@Field("act_start_date")
	private Date activityStartDate;
	@Field("act_end_date")
	private Date activityEndDate;
		
	
	@Field("attnd_report")
	private List<AttendanaceReport> attendanaceReport;

	/*@PersistenceConstructor
	public Attendance(@Value("_id.group_id") String groupId, @Value("_id.grp_owner_id") String ownerId, @Value("_id.grp_activity_id") String activityId, 
			@Value("_id.act_start_date")Date activityStartDate, @Value("_id.act_end_date")Date activityEndDate, @Value("attnd_report")List<AttendanaceReport> attendanaceReport) {
		super();		
		//this._id = new AttendanceId(groupId, activityId, ownerId, activityStartDate, activityEndDate);
		this.attendanaceReport = attendanaceReport;
		//LOGGER.info("##########attendanaceReport######" + attendanaceReport.size());
	}*/
	
	
	
	public Attendance registerAttendance(String entityId, String attendanceStatus) {
		this.attendanaceReport.add(new AttendanaceReport(entityId, attendanceStatus));
		
		return this;
	}

	public Attendance(String groupId, String ownerId, String activityId,
			Date activityStartDate, Date activityEndDate,
			List<AttendanaceReport> attendanaceReport) {
		super();
		this.groupId = groupId;
		this.ownerId = ownerId;
		this.activityId = activityId;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
		this.attendanaceReport = attendanaceReport;
	}

	public List<AttendanaceReport> getAttendanaceReport() {
		return attendanaceReport;
	}	
}
