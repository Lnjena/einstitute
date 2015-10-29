package com.einstitute.core.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="ent_permission")
public class EntityPermission {
	
	@Id
	private String _id;	
	
	@Field("usr_permission")
	private ComponentPermission userPermission;
	
	@Field("grp_permissions")
	private List<ComponentPermission> groupsPermissions;
	
	@Field("othr_permission")
	private ComponentPermission otherPermission;

	public EntityPermission(String _id, ComponentPermission userPermission,
			List<ComponentPermission> groupsPermissions,
			ComponentPermission otherPermission) {
		super();
		this._id = _id;
		this.userPermission = userPermission;
		this.groupsPermissions = groupsPermissions;
		this.otherPermission = otherPermission;
	}


	public ComponentPermission getUserPermission() {
		return userPermission;
	}


	public void setGroupsPermissions(List<ComponentPermission> groupPermissions) {
		this.groupsPermissions = groupPermissions;
	}


	public List<ComponentPermission> getGroupsPermissions() {
		return groupsPermissions;
	}


	public ComponentPermission getOtherPermission() {
		return otherPermission;
	}


	public String get_id() {
		return _id;
	}
}
