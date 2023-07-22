package com.example.cashflow.controller;

import com.example.cashflow.dto.PersonDTO;
import com.example.cashflow.form.PersonForm;
import com.example.cashflow.form.UpdatePersonForm;
import com.example.cashflow.form.UpdateUserForm;
import com.example.cashflow.service.PersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

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
        return ResponseEntity.ok(this.personService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PersonDTO> create(@RequestBody @Valid PersonForm form, UriComponentsBuilder uriBuilder) {
        PersonDTO personDTO = personService.save(form);

        URI uri = uriBuilder.path("/depoimentos/{id}").buildAndExpand(personDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(personDTO);
    }

    @PutMapping
    public ResponseEntity<PersonDTO> update(@RequestBody @Valid UpdatePersonForm form) {
        PersonDTO personDTO = personService.update(form);
        return ResponseEntity.ok(personDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
