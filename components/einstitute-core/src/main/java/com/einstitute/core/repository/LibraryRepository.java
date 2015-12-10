package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.LibraryInventory;

public interface LibraryRepository extends MongoRepository<LibraryInventory, String> {

}
