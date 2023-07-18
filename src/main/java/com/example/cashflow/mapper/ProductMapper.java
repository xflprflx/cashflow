package com.example.cashflow.mapper;

import com.example.cashflow.form.ProductForm;
import com.example.cashflow.model.Product;

public class ProductMapper {

    public Product create (ProductForm form) {
        return new Product(form.getName(), form.getDescription(), form.getPrice());
    }
}
