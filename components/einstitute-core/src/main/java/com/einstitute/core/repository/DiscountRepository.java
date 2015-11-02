package com.einstitute.core.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Discount;

public interface DiscountRepository extends MongoRepository<Discount, ObjectId> {

}
