package org.example.eventsourcingcqrsspringbootaxon.query.repository;

import org.example.eventsourcingcqrsspringbootaxon.query.entity.AccountOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<AccountOperation,Long> {
    List<AccountOperation> findByAccountId(String id);
}