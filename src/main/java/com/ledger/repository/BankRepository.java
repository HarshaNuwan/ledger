package com.ledger.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ledger.model.BankEntity;

public interface BankRepository extends JpaRepository<BankEntity, Long> {

}
