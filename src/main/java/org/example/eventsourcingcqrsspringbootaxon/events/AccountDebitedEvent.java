package org.example.eventsourcingcqrsspringbootaxon.events;

public record AccountDebitedEvent(String accountId, double amount, String currency) {
}
