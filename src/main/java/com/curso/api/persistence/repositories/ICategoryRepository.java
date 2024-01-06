package com.curso.api.persistence.repositories;

import com.curso.api.persistence.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Long> {
}
