package com.example.cashflow.dto;

import com.example.cashflow.model.Person;

public class PersonDTO {

    private final Long id;
    private final String name;

    public PersonDTO(Person person) {
        this.id = person.getId();
        this.name = person.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
