package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

}
