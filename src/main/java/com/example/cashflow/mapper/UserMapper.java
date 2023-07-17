package com.example.cashflow.mapper;

import com.example.cashflow.form.UpdateUserForm;
import com.example.cashflow.form.UserForm;
import com.example.cashflow.model.User;

public class UserMapper {

    public User create(UserForm form) {
        User user = new User(form.getName(), form.getUsername(), form.getEmail(), form.getPassword());
        if (user.getPhone() != null || !user.getPhone().isEmpty()) {
            user.setPhone(form.getPhone());
        }
        return user;
    }

    public User update(User user, UpdateUserForm form) {
        user.setName(form.getName());
        user.setEmail(form.getEmail());
        user.setPassword(form.getPassword());
        user.setUsername(form.getUsername());

        if (form.getPhone() != null) {
            user.setPhone(form.getPhone());
        }

        return user;
    }

}
