package com.curso.api.persistence.repositories;

import com.curso.api.persistence.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product, Long> {
}
