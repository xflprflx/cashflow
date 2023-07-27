package com.example.cashflow.mapper;

import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.form.ProductForm;
import com.example.cashflow.model.Brand;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.Product;
import com.example.cashflow.repository.BrandRepository;
import com.example.cashflow.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final CategoryRepository categoryRepository;
    private final BrandRepository brandRepository;

    @Autowired
    public ProductMapper(CategoryRepository categoryRepository, BrandRepository brandRepository) {
        this.categoryRepository = categoryRepository;
        this.brandRepository = brandRepository;
    }

    public Product create (ProductForm form) {
        Product product = new Product(form.getName(), form.getDescription(), form.getPrice());
        for(CategoryForm cat : form.getCategories()) {
            Category category = categoryRepository.findByName(cat.getName());
            if (category == null) {
                category = new Category(cat.getName());
                category = categoryRepository.save(category);
            }
            product.getCategories().add(category);
        }
        Brand brand = brandRepository.findByName(form.getBrand().getName());
        if (brand == null){
            brand = brandRepository.save(new Brand(form.getBrand().getName()));
        }
        product.setBrand(brand);
        return product;
    }
}
