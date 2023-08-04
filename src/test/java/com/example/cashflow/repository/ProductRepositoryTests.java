package com.example.cashflow.repository;

import com.example.cashflow.model.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Optional;

@DataJpaTest
public class ProductRepositoryTests {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void deleteShouldThrowEmptyResultDataAccessExceptionWhenIdDoesNotExist() {
        long nonExistingId = 1000L;
        Assertions.assertThrows(EmptyResultDataAccessException.class, () -> {
           productRepository.deleteById(nonExistingId);
        });
    }
}
