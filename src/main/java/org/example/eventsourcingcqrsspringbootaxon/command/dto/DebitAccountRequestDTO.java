package org.example.eventsourcingcqrsspringbootaxon.command.dto;

public record DebitAccountRequestDTO(String accountId, double amount, String currency) {
}