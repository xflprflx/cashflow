package com.example.cashflow.mapper;

import com.example.cashflow.form.PaymentForm;
import com.example.cashflow.form.UpdatePaymentForm;
import com.example.cashflow.model.Payment;

public class PaymentMapper {

    public Payment create(PaymentForm form) {
        return new Payment(form.getPayDay(), form.getPaymentStatus(), form.getAmount());
    }

    public Payment update(Payment payment, UpdatePaymentForm form) {
        payment.setPayDay(form.getPayDay());
        payment.setPaymentStatus(form.getPaymentStatus());
        payment.setAmount(form.getAmount());

        return payment;
    }
}
