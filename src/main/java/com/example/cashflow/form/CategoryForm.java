package com.example.cashflow.form;

import javax.validation.constraints.NotBlank;

public class CategoryForm {

    @NotBlank(message = "The name field cannot be blank")
    private String name;

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }
}
