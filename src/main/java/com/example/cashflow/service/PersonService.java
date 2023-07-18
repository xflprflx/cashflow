package com.example.cashflow.service;

import com.example.cashflow.dto.PersonDTO;
import com.example.cashflow.model.Person;
import com.example.cashflow.repository.PersonRepository;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO findById(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));
        return new PersonDTO(person);
    }
}
