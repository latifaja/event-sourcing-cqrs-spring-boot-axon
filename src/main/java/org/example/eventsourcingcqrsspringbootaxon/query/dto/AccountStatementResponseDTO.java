package org.example.eventsourcingcqrsspringbootaxon.query.dto;

import org.example.eventsourcingcqrsspringbootaxon.query.entity.Account;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.AccountOperation;

import java.util.List;

public record AccountStatementResponseDTO(Account account, List<AccountOperation> operations)
{
}