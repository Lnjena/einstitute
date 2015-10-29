package com.einstitute.core.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="organisation")
public class Organisation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3079687803842600457L;
	
	@Id
	private String _id;
	
	@Field("parent_org_code")
	private String parentOrgCode;
	
	@Field("branch_org_codes")
	private List<String> branchOrgCodes;
	
	@Field("is_active")
	private boolean active;

	public Organisation(String _id, String parentOrgCode,
			List<String> branchOrgCodes, boolean active) {
		super();
		this._id = _id;
		this.parentOrgCode = parentOrgCode;
		this.branchOrgCodes = branchOrgCodes;
		this.active = active;
	}
}
