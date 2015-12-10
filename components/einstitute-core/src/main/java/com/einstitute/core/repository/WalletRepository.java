package com.einstitute.core.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.einstitute.core.domain.Wallet;

public interface WalletRepository extends MongoRepository<Wallet, String> {

}
