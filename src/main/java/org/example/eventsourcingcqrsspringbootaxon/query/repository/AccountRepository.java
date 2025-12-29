package org.example.eventsourcingcqrsspringbootaxon.query.repository;

import org.example.eventsourcingcqrsspringbootaxon.query.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}