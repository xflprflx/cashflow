package com.example.cashflow.service;

import com.example.cashflow.dto.PaymentDTO;
import com.example.cashflow.form.PaymentForm;
import com.example.cashflow.form.UpdatePaymentForm;
import com.example.cashflow.mapper.PaymentMapper;
import com.example.cashflow.model.Payment;
import com.example.cashflow.repository.PaymentRepository;
import com.example.cashflow.service.exceptions.DatabaseException;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public PaymentDTO findById(Long id) {
        Payment payment = paymentRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        return new PaymentDTO(payment);
    }

    @Transactional
    public PaymentDTO insert(PaymentForm form) {
        Payment payment = new PaymentMapper().create(form);
        paymentRepository.save(payment);

        return new PaymentDTO(payment);
    }

    @Transactional
    public PaymentDTO update(UpdatePaymentForm form) {
        Payment payment = paymentRepository
                .findById(form.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found"));

        Payment updated = new PaymentMapper().update(payment, form);
        return new PaymentDTO(updated);
    }

    public void delete(Long id) {
        try {
            paymentRepository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Payment not found: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
