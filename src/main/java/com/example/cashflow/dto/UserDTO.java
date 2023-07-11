package com.example.cashflow.dto;

import com.example.cashflow.model.User;

import javax.persistence.Column;

public class UserDTO {

    private final Long id;
    private final String name;
    private final String username;
    private final String email;
    private final String password;
    private final String phone;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.phone = user.getPhone();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }
}
