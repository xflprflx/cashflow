package com.example.cashflow.controller;

import com.example.cashflow.dto.PaymentDTO;
import com.example.cashflow.form.PaymentForm;
import com.example.cashflow.form.UpdatePaymentForm;
import com.example.cashflow.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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

    @GetMapping("/{id}")
    public ResponseEntity<PaymentDTO> detail(@PathVariable Long id) {
        PaymentDTO paymentDTO = paymentService.findById(id);
        return ResponseEntity.ok(paymentDTO);
    }

    @PostMapping
    public ResponseEntity<PaymentDTO> insert(@RequestBody @Valid PaymentForm form, UriComponentsBuilder uriBuilder) {
        PaymentDTO paymentDTO = paymentService.insert(form);

        URI uri = uriBuilder.path("/payment/{id}").buildAndExpand(paymentDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(paymentDTO);
    }

    @PutMapping
    public ResponseEntity<PaymentDTO> update(@RequestBody @Valid UpdatePaymentForm form) {
        PaymentDTO paymentDTO = paymentService.update(form);
        return ResponseEntity.ok(paymentDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        paymentService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
