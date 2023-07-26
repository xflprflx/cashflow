package com.example.cashflow.model;

import javax.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    private Integer invoiceClosingDay;

    private Integer invoiceDueDay;

    private Double balance;

    public Account() {
    }

    public Account(String name, Integer invoiceClosingDay, Integer invoiceDueDay, Double balance) {
        this.name = name;
        this.invoiceClosingDay = invoiceClosingDay;
        this.invoiceDueDay = invoiceDueDay;
        this.balance = balance;
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
