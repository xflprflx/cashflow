package com.example.cashflow.mapper;

import com.example.cashflow.form.BrandForm;
import com.example.cashflow.model.Brand;

public class BrandMapper {

    public Brand create (BrandForm form) {
        return new Brand(form.getName());
    }
}
