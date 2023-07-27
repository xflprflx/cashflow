package com.example.cashflow.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@PrimaryKeyJoinColumn(name = "person_id")
public class User extends Person{
    @Column(nullable = false, length = 100)
    private String username;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 50)
    private String password;

    @Column(length = 14)
    private String phone;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Person> persons = new ArrayList<>();

    public User() {
    }

    public User(String name, String username, String email, String password) {
        super(name);
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
