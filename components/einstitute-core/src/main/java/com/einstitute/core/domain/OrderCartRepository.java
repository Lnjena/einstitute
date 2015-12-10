package com.einstitute.core.domain;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderCartRepository extends MongoRepository<OrderCart, ObjectId> {

}
