package com.example.cashflow.service;

import com.example.cashflow.dto.CategoryDTO;
import com.example.cashflow.model.Category;
import com.example.cashflow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
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
}
