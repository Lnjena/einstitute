package com.einstitute.core.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Payment;

public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {

}
