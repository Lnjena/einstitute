package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.einstitute.core.domain.schedule.Schedule;

@Document(collection="activity")
public class Activity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -478776900586564460L;
	
	@Id
	private ObjectId _id;
	
	@Field("act_owner_id")
	private String ownerId;
	
	@Field("act_assigned_grp_ids")
	private List<String> assignedGroupIds;
	
	@Transient
	private List<EntityGroup> assignedGroups;
	
	@Field("act_desc")
	private String description;
	
	@Field("act_schedule")
	private Schedule schedule;	
	
	@Field("act_payable")
	private Boolean payable;
	
	@Field("act_payment")
	private ObjectId paymentId;
	
	public Activity(String ownerId, List<String> assignedGroupIds, String description, Schedule schedule) {
		this.ownerId = ownerId;
		this.assignedGroupIds = assignedGroupIds;
		this.description = description;
		this.schedule = schedule;
	}

	public Activity(String ownerId, List<String> assignedGroupIds, String description, Schedule schedule, Boolean payable,
			ObjectId paymentId) {
		this(ownerId, assignedGroupIds, description, schedule);
		
		if(payable == true) {
			this.payable = payable;
			this.paymentId = paymentId;
		}
	}
	
}
