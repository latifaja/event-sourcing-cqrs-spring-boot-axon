package org.example.eventsourcingcqrsspringbootaxon.command.dto;

public record AddNewAccountRequestDTO(double initialBalance, String currency) {
}