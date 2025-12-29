package org.example.eventsourcingcqrsspringbootaxon.events;

import org.example.eventsourcingcqrsspringbootaxon.enums.AccountStatus;

public record AccountCreatedEvent(String accountId, double initialBalance, String currency, AccountStatus accountStatus) {
}
