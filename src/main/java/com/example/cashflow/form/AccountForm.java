package com.example.cashflow.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class AccountForm {

    @NotBlank(message = "The name field cannot be blank")
    private String name;

    private Integer invoiceClosingDay;

    private Integer invoiceDueDay;

    @PositiveOrZero
    private Double balance;

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

    public void setName(String name) {
        this.name = name;
    }

    public void setInvoiceClosingDay(Integer invoiceClosingDay) {
        this.invoiceClosingDay = invoiceClosingDay;
    }

    public void setInvoiceDueDay(Integer invoiceDueDay) {
        this.invoiceDueDay = invoiceDueDay;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
