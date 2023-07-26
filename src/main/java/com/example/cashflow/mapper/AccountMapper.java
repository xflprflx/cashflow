package com.example.cashflow.mapper;

import com.example.cashflow.form.AccountForm;
import com.example.cashflow.form.UpdateAccountForm;
import com.example.cashflow.model.Account;

public class AccountMapper {

    public Account create(AccountForm form) {
        return new Account(form.getName(), form.getInvoiceClosingDay(), form.getInvoiceDueDay(), form.getBalance());
    }

    public Account update(Account account, UpdateAccountForm form) {
        account.setName(form.getName());
        account.setInvoiceClosingDay(form.getInvoiceClosingDay());
        account.setInvoiceDueDay(form.getInvoiceDueDay());
        account.setBalance(form.getBalance());

        return account;
    }
}
