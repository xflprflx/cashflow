package com.example.cashflow.mapper;

import com.example.cashflow.form.AccountForm;
import com.example.cashflow.model.Account;

public class AccountMapper {

    public Account create(AccountForm form) {
        return new Account(form.getName(), form.getInvoiceClosingDay(), form.getInvoiceDueDay(), form.getBalance());
    }
}
