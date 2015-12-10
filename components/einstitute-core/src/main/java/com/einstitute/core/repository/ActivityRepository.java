package com.einstitute.core.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Activity;

public interface ActivityRepository extends MongoRepository<Activity, ObjectId>{
	
}
