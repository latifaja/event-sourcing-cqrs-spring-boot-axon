package org.example.eventsourcingcqrsspringbootaxon.events;

import org.example.eventsourcingcqrsspringbootaxon.enums.AccountStatus;

public record AccountStatusUpdatedEvent(String accountId, AccountStatus status) {
}