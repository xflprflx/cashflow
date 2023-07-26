package com.example.cashflow.service;

import com.example.cashflow.dto.AccountDTO;
import com.example.cashflow.model.Account;
import com.example.cashflow.repository.AccountRepository;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Transactional(readOnly = true)
    public List<AccountDTO> findAll() {
        List<Account> accounts = accountRepository
                .findAll(Sort.by(Sort.Direction.ASC, "id"));

        return accounts.stream().map(AccountDTO::new).collect(Collectors.toList());
    }

    public AccountDTO findById(Long id) {
        Account account = accountRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        return new AccountDTO(account);
    }
}
