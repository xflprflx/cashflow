package com.example.cashflow.mapper;

import com.example.cashflow.form.PersonForm;
import com.example.cashflow.form.UpdatePersonForm;
import com.example.cashflow.model.Person;

public class PersonMapper {

    public Person create(PersonForm form) {
        return new Person(form.getName());
    }

    public Person update(Person person, UpdatePersonForm form) {
        person.setName(form.getName());

        return person;
    }
}
