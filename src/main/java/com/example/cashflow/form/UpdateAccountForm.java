package com.example.cashflow.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

public class UpdateAccountForm {

    @NotBlank(message = "The account id cannot be blank")
    private Long id;

    @NotBlank(message = "The name field cannot be blank")
    private String name;

    private Integer invoiceClosingDay;

    private Integer invoiceDueDay;

    @PositiveOrZero
    private Double balance;

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
