package com.example.cashflow.service;

import com.example.cashflow.dto.UserDTO;
import com.example.cashflow.model.User;
import com.example.cashflow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
