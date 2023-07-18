package com.example.cashflow.service;

import com.example.cashflow.dto.CategoryDTO;
import com.example.cashflow.dto.ProductDTO;
import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.form.ProductForm;
import com.example.cashflow.mapper.CategoryMapper;
import com.example.cashflow.mapper.ProductMapper;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.Product;
import com.example.cashflow.repository.ProductRepository;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
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

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDTO(entity);
    }

    @Transactional
    public ProductDTO insert(ProductForm form) {
        Product product = new ProductMapper().create(form);
        product = repository.save(product);
        return new ProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductForm form) {
        try {
            Product entity = repository.getReferenceById(id);
            entity.setName(form.getName());
            entity.setDescription(form.getDescription());
            entity.setPrice(form.getPrice());
            return new ProductDTO(repository.save(entity));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
    }
}
