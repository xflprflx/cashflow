package com.example.cashflow.mapper;

import com.example.cashflow.form.CategoryForm;
import com.example.cashflow.model.Category;

public class CategoryMapper {

    public Category create (CategoryForm form) {
        return new Category(form.getName());
    }

}
