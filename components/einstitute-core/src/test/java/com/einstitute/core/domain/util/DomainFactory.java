package com.einstitute.core.domain.util;

import com.einstitute.core.domain.Organisation;

public abstract class DomainFactory {
	
	
	public static Organisation getOrganisation(String id) {
		return new Organisation(id);
	}
	
	
}
