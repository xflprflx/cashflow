package com.example.cashflow.service;

import com.example.cashflow.dto.ProductDTO;
import com.example.cashflow.model.Product;
import com.example.cashflow.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }
}
