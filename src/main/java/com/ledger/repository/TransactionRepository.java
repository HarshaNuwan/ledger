package com.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledger.model.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

}
