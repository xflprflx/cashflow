package com.example.cashflow.form;

import com.example.cashflow.model.PaymentStatus;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.Instant;

public class UpdatePaymentForm {

    @NotNull(message = "The id connot be null")
    private Long id;

    @FutureOrPresent(message = "The payDay must be a future date or present")
    private Instant payDay;

    @NotBlank(message = "The payment status field cannot be blank")
    private PaymentStatus paymentStatus;

    @Positive(message = "The amount must be a positive value")
    private BigDecimal amount;

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
