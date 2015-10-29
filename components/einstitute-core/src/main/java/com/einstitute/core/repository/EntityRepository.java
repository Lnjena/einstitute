package com.einstitute.core.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Entity;

public interface EntityRepository extends MongoRepository<Entity, String> {
	
	public List<Entity> findByEntityType(String entityType);
	
	public Entity findBy_id(String id);

}
