package org.example.eventsourcingcqrsspringbootaxon.query.handler;


import lombok.AllArgsConstructor;
import org.axonframework.queryhandling.QueryHandler;
import org.example.eventsourcingcqrsspringbootaxon.query.dto.AccountStatementResponseDTO;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.Account;
import org.example.eventsourcingcqrsspringbootaxon.query.entity.AccountOperation;
import org.example.eventsourcingcqrsspringbootaxon.query.query.GetAccountStatementQuery;
import org.example.eventsourcingcqrsspringbootaxon.query.query.GetAllAccountsQuery;
import org.example.eventsourcingcqrsspringbootaxon.query.repository.OperationRepository;
import org.example.eventsourcingcqrsspringbootaxon.query.repository.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class AccountQueryHandler {
    private AccountRepository accountRepository;
    private OperationRepository operationRepository;

    @QueryHandler
    public List<Account> on(GetAllAccountsQuery query) {
        return accountRepository.findAll();
    }

    @QueryHandler
    public AccountStatementResponseDTO on(GetAccountStatementQuery query) {
        Account account = accountRepository.findById(query.getAccountId()).get();
        List<AccountOperation> operations = operationRepository.findByAccountId(query.getAccountId());
        return new AccountStatementResponseDTO(account, operations);
    }
}
