package org.example.eventsourcingcqrsspringbootaxon.command.dto;

import org.example.eventsourcingcqrsspringbootaxon.enums.AccountStatus;

public record UpdateAccountStatusRequestDTO(String accountId, AccountStatus status) {
}