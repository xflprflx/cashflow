package com.example.cashflow.controller;

import com.example.cashflow.dto.PaymentDTO;
import com.example.cashflow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<PaymentDTO>> findAll() {
        List<PaymentDTO> paymentDTOList = paymentService.findAll();
        return ResponseEntity.ok(paymentDTOList);
    }

}
