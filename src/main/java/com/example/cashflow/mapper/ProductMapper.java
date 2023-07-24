package com.example.cashflow.mapper;

import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.form.ProductForm;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.Product;
import com.example.cashflow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Product create (ProductForm form) {

        Product product = new Product(form.getName(), form.getDescription(), form.getPrice());

        /*Set<Category> categories = new HashSet<>();*/
        for(CategoryForm cat : form.getCategories()) {
            Category category = categoryRepository.findByName(cat.getName());
            if (category == null) {
                category = new Category();
                category.setName(cat.getName());
                category = categoryRepository.save(category);
            }
            product.getCategories().add(category);
            /*categories.add(category);*/
        }
        /*categories.forEach(cat -> product.getCategories().add(cat));*/
        return product;
    }
}
