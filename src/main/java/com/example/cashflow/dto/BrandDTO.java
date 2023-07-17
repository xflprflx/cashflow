package com.example.cashflow.dto;

import com.example.cashflow.model.Brand;

import java.io.Serializable;

public class BrandDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

    public BrandDTO() {
    }

    public BrandDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public BrandDTO(Brand entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
