package org.example.eventsourcingcqrsspringbootaxon.command.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.example.eventsourcingcqrsspringbootaxon.enums.AccountStatus;

@Getter @Setter @AllArgsConstructor
public class UpdateAccountStatusCommand {
    @TargetAggregateIdentifier
    private String id;
    private AccountStatus status;
}