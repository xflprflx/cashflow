package com.example.cashflow.dto;

import com.example.cashflow.model.Payment;
import com.example.cashflow.model.PaymentStatus;

import java.math.BigDecimal;
import java.time.Instant;

public class PaymentDTO {

    private final Long id;
    private final Instant payDay;
    private final PaymentStatus paymentStatus;
    private final BigDecimal amount;

    public PaymentDTO(Payment payment) {
        this.id = payment.getId();
        this.payDay = payment.getPayDay();
        this.paymentStatus = payment.getPaymentStatus();
        this.amount = payment.getAmount();
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
}
