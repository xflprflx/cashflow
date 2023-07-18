package com.example.cashflow.controller;

import com.example.cashflow.dto.PersonDTO;
import com.example.cashflow.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persons")
@CrossOrigin
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(this.personService.findById(id));
    }

}
