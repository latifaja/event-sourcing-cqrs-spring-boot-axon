package org.example.eventsourcingcqrsspringbootaxon.query.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;

import org.example.eventsourcingcqrsspringbootaxon.events.*;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.Account;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.AccountOperation;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.OperationType;
import org.example.eventsourcingcqrsspringbootaxon.query.repository.AccountRepository;
import org.example.eventsourcingcqrsspringbootaxon.query.repository.OperationRepository;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AccountEventHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @EventHandler
    public void on(AccountCreatedEvent event, EventMessage eventMessage) {
        log.info("################# Query side AccountCreatedEvent received #################");
        Account account = Account.builder()
                .id(event.accountId())
                .balance(event.initialBalance())
                .status(event.accountStatus())
                .currency(event.currency())
                .createdAt(eventMessage.getTimestamp())
                .build();
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountActivatedEvent event, EventMessage eventMessage) {
        log.info("################# Query side AccountActivatedEvent received #################");
        Account account = accountRepository.findById(event.accountId()).get();
        account.setStatus(event.status());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountStatusUpdatedEvent event, EventMessage eventMessage) {
        log.info("################# Query side AccountStatusUpdatedEvent received #################");
        Account account = accountRepository.findById(event.accountId()).get();
        account.setStatus(event.status());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountCreditedEvent event, EventMessage eventMessage) {
        log.info("################# Query side AccountCreditedEvent received #################");
        Account account = accountRepository.findById(event.accountId()).get();
        AccountOperation accountOperation = AccountOperation.builder()
                .amount(event.amount())
                .date(eventMessage.getTimestamp())
                .type(OperationType.CREDIT)
                .currency(event.currency())
                .account(account)
                .build();
        operationRepository.save(accountOperation);
        account.setBalance(account.getBalance() + accountOperation.getAmount());
        accountRepository.save(account);
    }

    @EventHandler
    public void on(AccountDebitedEvent event, EventMessage eventMessage) {
        log.info("################# Query side AccountDebitedEvent received #################");
        Account account = accountRepository.findById(event.accountId()).get();
        AccountOperation accountOperation = AccountOperation.builder()
                .amount(event.amount())
                .date(eventMessage.getTimestamp())
                .type(OperationType.DEBIT)
                .currency(event.currency())
                .account(account)
                .build();
        operationRepository.save(accountOperation);
        account.setBalance(account.getBalance() - accountOperation.getAmount());
        accountRepository.save(account);
    }
}