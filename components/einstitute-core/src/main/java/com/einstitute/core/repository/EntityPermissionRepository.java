package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.EntityPermission;

public interface EntityPermissionRepository extends MongoRepository<EntityPermission, String> {

}
