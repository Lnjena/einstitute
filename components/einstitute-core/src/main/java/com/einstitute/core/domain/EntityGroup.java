package com.einstitute.core.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Document(collection="entity_group")
public class EntityGroup {

	@Id
	private String groupId;
	
	@DBRef
	@Field("grp_members")
	private List<Entity> groupMembers;
	
	@Field("grp_desc")
	private String groupDescription;
	
	@Field("grp_actv_date")
	private Date groupActivationDate;
	
	@Field("grp_term_date")
	private Date groupTerminationDate;

	public EntityGroup(String groupId, String groupDescription,
			Date groupActivationDate, Date groupTerminationDate) {
		super();
		this.groupId = groupId;
		this.groupDescription = groupDescription;
		this.groupActivationDate = groupActivationDate;
		this.groupTerminationDate = groupTerminationDate;
		this.groupMembers = new ArrayList<Entity>();
	}
	
	public List<Entity> getGroupMembers() {
		return groupMembers;
	}

	public void setGroupMembers(List<Entity> groupMembers) {
		this.groupMembers = groupMembers;
	}
	
	public void addGroupMember(Entity groupMember) {
		this.groupMembers.add(groupMember);
	}

	public String getGroupId() {
		return groupId;
	}

	public String getGroupDescription() {
		return groupDescription;
	}

	public Date getGroupActivationDate() {
		return groupActivationDate;
	}

	public Date getGroupTerminationDate() {
		return groupTerminationDate;
	}
	
}
