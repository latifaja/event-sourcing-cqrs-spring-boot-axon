package org.example.eventsourcingcqrsspringbootaxon.events;

public record AccountCreditedEvent(String accountId, double amount, String currency) {
}