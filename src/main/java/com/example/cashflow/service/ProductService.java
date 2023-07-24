package com.example.cashflow.service;

import com.example.cashflow.dto.ProductDTO;
import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.form.ProductForm;
import com.example.cashflow.mapper.ProductMapper;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.Product;
import com.example.cashflow.repository.CategoryRepository;
import com.example.cashflow.repository.ProductRepository;
import com.example.cashflow.service.exceptions.DatabaseException;
import com.example.cashflow.service.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return list.stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        Product entity = obj.orElseThrow(() -> new ResourceNotFoundException("Entity not found"));
        return new ProductDTO(entity, entity.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductForm form) {
        /*Product product = new Product();
        copyFormToEntity(form, product);*/
        Product product = new ProductMapper(categoryRepository).create(form);
        product = repository.save(product);
        return new ProductDTO(product, product.getCategories());
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

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Id not found: " + id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }


    public Product create (ProductForm form) {

        Product product = new Product(form.getName(), form.getDescription(), form.getPrice());

        Set<Category> categories = new HashSet<>();
        for(CategoryForm cat : form.getCategories()) {
            Category category = categoryRepository.findByName(cat.getName());
            if (category == null) {
                category = new Category();
                category.setName(cat.getName());
                category = categoryRepository.save(category);
            }

            categories.add(category);
        }
        categories.forEach(cat -> product.getCategories().add(cat));
        return product;
    }

    private void copyFormToEntity(ProductForm form, Product entity){
        entity.setName(form.getName());
        entity.setDescription(form.getDescription());
        entity.setPrice(form.getPrice());
        entity.getCategories().clear();
        for (CategoryForm categoryForm : form.getCategories()) {
            Category category = categoryRepository.findByName(categoryForm.getName());
            entity.getCategories().add(category);
        }
    }
}
