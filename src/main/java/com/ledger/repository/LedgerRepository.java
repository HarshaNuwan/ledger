package com.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledger.model.LedgerEntity;

public interface LedgerRepository extends JpaRepository<LedgerEntity, Long> {

}
