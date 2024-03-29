package com.curso.api.persistence.repositories.security;

import com.curso.api.persistence.entities.security.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
