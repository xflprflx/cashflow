package com.example.cashflow.tests;

import com.example.cashflow.dto.ProductDTO;
import com.example.cashflow.model.Brand;
import com.example.cashflow.model.Category;
import com.example.cashflow.model.Product;

import java.math.BigDecimal;

public class Factory {

    public static Product createProduct() {
        Product product = new Product(1L, "Phone", "Good Phone", new BigDecimal("800.0"));
        product.setBrand(new Brand(1L, "Samsung"));
        product.getCategories().add(new Category(1L, "Electronics"));
        return product;
    }

    public static ProductDTO creatProductDTO(){
        Product product = createProduct();
        return  new ProductDTO(product, product.getBrand(), product.getCategories());
    }
}
