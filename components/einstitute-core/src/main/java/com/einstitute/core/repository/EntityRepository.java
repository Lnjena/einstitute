package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Entity;

public interface EntityRepository extends MongoRepository<Entity, String> {

}
