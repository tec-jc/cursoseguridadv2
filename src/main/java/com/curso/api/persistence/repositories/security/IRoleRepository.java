package com.curso.api.persistence.repositories.security;

import com.curso.api.persistence.entities.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(String defaultRole);
}
