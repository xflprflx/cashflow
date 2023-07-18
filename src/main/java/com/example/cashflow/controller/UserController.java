package com.example.cashflow.controller;

import com.example.cashflow.dto.CategoryDTO;
import com.example.cashflow.dto.UserDTO;
import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.form.UpdateUserForm;
import com.example.cashflow.form.UserForm;
import com.example.cashflow.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }

    @PostMapping
    public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserForm form, UriComponentsBuilder uriBuilder) {
        UserDTO userDTO = userService.save(form);

        URI uri = uriBuilder.path("users/{id}").buildAndExpand(userDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(userDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UpdateUserForm form) {
        UserDTO userDTO = userService.update(id, form);
        return ResponseEntity.ok().body(userDTO);
    }

}
