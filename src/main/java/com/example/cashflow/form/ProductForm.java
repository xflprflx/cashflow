package com.example.cashflow.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class ProductForm {

    @NotBlank(message = "The name field cannot be blank")
    private String name;
    @NotBlank(message = "The description field cannot be blank")
    private String description;
    @NotBlank(message = "The price field cannot be blank")
    @DecimalMin(value = "0.01", message = "Minimum price should be 0.01")
    @Digits(integer = Integer.MAX_VALUE, fraction = 2, message = "The price must have a maximum of 2 decimal places")
    private BigDecimal price;

    @NotNull
    private BrandForm brand;
    @NotNull
    Set<CategoryForm> categories = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BrandForm getBrand() {
        return brand;
    }

    public void setBrand(BrandForm brand) {
        this.brand = brand;
    }

    public Set<CategoryForm> getCategories() {
        return categories;
    }
}
