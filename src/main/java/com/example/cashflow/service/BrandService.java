package com.example.cashflow.service;

import com.example.cashflow.dto.BrandDTO;
import com.example.cashflow.model.Brand;
import com.example.cashflow.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrandService {

    @Autowired
    private BrandRepository repository;

    public List<BrandDTO> findAll() {
        List<Brand> brands = repository.findAll(Sort.by(Sort.Direction.ASC, "id"));
        return brands.stream().map(BrandDTO::new).collect(Collectors.toList());
    }
}
