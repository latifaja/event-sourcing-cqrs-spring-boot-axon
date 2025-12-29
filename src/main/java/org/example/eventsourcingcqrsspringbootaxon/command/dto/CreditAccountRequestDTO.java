package org.example.eventsourcingcqrsspringbootaxon.command.dto;

public record CreditAccountRequestDTO(String accountId, double amount, String currency) {
}