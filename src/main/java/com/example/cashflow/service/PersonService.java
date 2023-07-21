package com.example.cashflow.service;

import com.example.cashflow.dto.PersonDTO;
import com.example.cashflow.form.PersonForm;
import com.example.cashflow.form.UpdatePersonForm;
import com.example.cashflow.mapper.PersonMapper;
import com.example.cashflow.model.Person;
import com.example.cashflow.model.User;
import com.example.cashflow.repository.PersonRepository;
import com.example.cashflow.service.exceptions.DatabaseException;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public PersonDTO save(PersonForm form) {
        Person person = new PersonMapper().create(form);
        personRepository.save(person);

        return new PersonDTO(person);
    }

    @Transactional
    public PersonDTO update(UpdatePersonForm form) {
        Person person = personRepository
                .findById(form.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        Person updated = new PersonMapper().update(person, form);

        return new PersonDTO(updated);
    }

    public void delete(Long id) {
        Person person = personRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found: " + id));

        try {
            personRepository.delete(person);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }
}
