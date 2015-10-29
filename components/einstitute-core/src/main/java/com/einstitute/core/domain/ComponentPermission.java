package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Field;

public class ComponentPermission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5654111626435625600L;
	
	@Field("grp_id")
	private String groupId;
	
	@Field("mod_perms")
	private List<Permission> modulePermissions;
	
	@Field("path_perms")
	private List<Permission> pathPermissions;
	
	@Field("elem_perms")
	private List<Permission> elementPermissions;
	
	public ComponentPermission(){}

	public ComponentPermission(List<Permission> modulePermissions,
			List<Permission> pathPermissions,
			List<Permission> elementPermissions) {
		super();
		this.modulePermissions = modulePermissions;
		this.pathPermissions = pathPermissions;
		this.elementPermissions = elementPermissions;
	}
	
	
	public ComponentPermission(String groupId,
			List<Permission> modulePermissions,
			List<Permission> pathPermissions,
			List<Permission> elementPermissions) {
		super();
		this.groupId = groupId;
		this.modulePermissions = modulePermissions;
		this.pathPermissions = pathPermissions;
		this.elementPermissions = elementPermissions;
	}



	public List<Permission> getModulePermissions() {
		return modulePermissions;
	}

	public List<Permission> getPathPermissions() {
		return pathPermissions;
	}

	public List<Permission> getElementPermissions() {
		return elementPermissions;
	}
}
