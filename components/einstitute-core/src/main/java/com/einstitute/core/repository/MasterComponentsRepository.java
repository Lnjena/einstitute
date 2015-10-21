package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.MasterComponent;

public interface MasterComponentsRepository extends MongoRepository<MasterComponent, String>{
	
}
