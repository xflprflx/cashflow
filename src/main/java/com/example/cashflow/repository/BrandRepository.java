package com.example.cashflow.repository;

import com.example.cashflow.model.Brand;
import com.example.cashflow.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);
}
