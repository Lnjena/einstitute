package com.einstitute.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Entity;
import com.einstitute.core.domain.EntityProfile;

public interface EntityProfileRepository extends MongoRepository<EntityProfile, String> {
	
	public List<Entity> findByEntityType(String entityType);
	
	public Entity findByEntityId(String userId);
}
