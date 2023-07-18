package com.example.cashflow.service;

import com.example.cashflow.dto.CategoryDTO;
import com.example.cashflow.dto.UserDTO;
import com.example.cashflow.form.UpdateUserForm;
import com.example.cashflow.form.UserForm;
import com.example.cashflow.mapper.UserMapper;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.User;
import com.example.cashflow.repository.UserRepository;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll(Sort.by(Sort.Direction.ASC, "user_id"));

        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    public UserDTO findById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return new UserDTO(user);
    }

    @Transactional
    public UserDTO save(UserForm form) {
        User user = new UserMapper().create(form);
        userRepository.save(user);

        return new UserDTO(user);
    }

    @Transactional
    public UserDTO update(Long id, UpdateUserForm form) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Id not found: " + id));

        User updated = new UserMapper().update(user, form);
        return new UserDTO(updated);
    }
}
