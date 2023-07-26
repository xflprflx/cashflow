package com.example.cashflow.service;

import com.example.cashflow.dto.AccountDTO;
import com.example.cashflow.form.AccountForm;
import com.example.cashflow.form.UpdateAccountForm;
import com.example.cashflow.mapper.AccountMapper;
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

    @Transactional
    public AccountDTO insert(AccountForm form) {
        Account account = new AccountMapper().create(form);
        accountRepository.save(account);

        return new AccountDTO(account);
    }

    @Transactional
    public AccountDTO update(UpdateAccountForm form) {
        Account account = accountRepository
                .findById(form.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Account not found"));

        Account updated = new AccountMapper().update(account, form);
        return new AccountDTO(updated);
    }
}
