package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Field;

public class AttendanceId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8187354049660019029L;
	
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
	
	public AttendanceId(String groupId, String activityId, String ownerId, Date activityStartDate, Date activityEndDate) {
		super();
		this.groupId = groupId;
		this.activityId = activityId;
		this.ownerId = ownerId;
		this.activityStartDate = activityStartDate;
		this.activityEndDate = activityEndDate;
	}

	public String getGroupId() {
		return groupId;
	}

	public String getActivityId() {
		return activityId;
	}

	public String getOwnerId() {
		return ownerId;
	}

	public Date getActivityStartDate() {
		return activityStartDate;
	}

	public Date getActivityEndDate() {
		return activityEndDate;
	}
}
