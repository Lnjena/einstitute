package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Organisation;

public interface OrganisationRepository extends MongoRepository<Organisation, String> {
	
}
