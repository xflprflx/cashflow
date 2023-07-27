package com.example.cashflow.dto;

import com.example.cashflow.model.Account;

public class AccountDTO {

    private final Long id;
    private final String name;
    private final Integer invoiceClosingDay;
    private final Integer invoiceDueDay;
    private final Double balance;

    public AccountDTO(Account account) {
        this.id = account.getId();
        this.name = account.getName();
        this.invoiceClosingDay = account.getInvoiceClosingDay();
        this.invoiceDueDay = account.getInvoiceDueDay();
        this.balance = account.getBalance();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getInvoiceClosingDay() {
        return invoiceClosingDay;
    }

    public Integer getInvoiceDueDay() {
        return invoiceDueDay;
    }

    public Double getBalance() {
        return balance;
    }
}
