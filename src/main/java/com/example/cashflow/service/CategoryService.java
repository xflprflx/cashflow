package com.example.cashflow.service;

import com.example.cashflow.dto.CategoryDTO;
import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.mapper.CategoryMapper;
import com.example.cashflow.model.Category;
import com.example.cashflow.repository.CategoryRepository;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> list = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return list.stream().map(x -> new CategoryDTO(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new CategoryDTO(entity);
    }

    @Transactional
    public CategoryDTO insert(CategoryForm form) {
        Category category = new CategoryMapper().create(form);
        category = repository.save(category);
        return new CategoryDTO(category);
    }
}
