package com.example.cashflow.controller;


import com.example.cashflow.dto.AccountDTO;
import com.example.cashflow.form.AccountForm;
import com.example.cashflow.model.Account;
import com.example.cashflow.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping
    public ResponseEntity<List<AccountDTO>> findAll() {
        List<AccountDTO> accountDTOList = accountService.findAll();

        return ResponseEntity.ok(accountDTOList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> datail(@PathVariable Long id) {
        AccountDTO accountDTO = accountService.findById(id);
        return ResponseEntity.ok(accountDTO);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> insert(@RequestBody @Valid AccountForm form, UriComponentsBuilder uriBuilder) {
        AccountDTO accountDTO = accountService.insert(form);

        URI uri = uriBuilder.path("/account/{id}").buildAndExpand(accountDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(accountDTO);
    }

}
