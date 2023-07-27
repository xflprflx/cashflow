package com.example.cashflow.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant payDay;
    @Enumerated(EnumType.STRING)
    @JoinColumn(nullable = false)
    private PaymentStatus paymentStatus;
    private BigDecimal amount;

    public Payment() {
    }

    public Payment(Instant payDay, PaymentStatus paymentStatus, BigDecimal amount) {
        this.payDay = payDay;
        this.paymentStatus = paymentStatus;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public Instant getPayDay() {
        return payDay;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setPayDay(Instant payDay) {
        this.payDay = payDay;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
