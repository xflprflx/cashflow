package com.example.cashflow.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdatePersonForm {
    
    @NotNull
    private Long id;

    @NotBlank(message = "The name field cannot be blank")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
