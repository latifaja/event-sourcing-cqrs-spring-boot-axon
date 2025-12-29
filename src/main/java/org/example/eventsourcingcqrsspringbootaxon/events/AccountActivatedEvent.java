package org.example.eventsourcingcqrsspringbootaxon.events;

import org.example.eventsourcingcqrsspringbootaxon.enums.AccountStatus;

public record AccountActivatedEvent(String accountId, AccountStatus status) {
}