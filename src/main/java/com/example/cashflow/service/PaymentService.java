package com.example.cashflow.service;

import com.example.cashflow.dto.PaymentDTO;
import com.example.cashflow.model.Payment;
import com.example.cashflow.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public List<PaymentDTO> findAll() {
        List<Payment> payments = paymentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        return payments.stream().map(PaymentDTO::new).collect(Collectors.toList());
    }

}
