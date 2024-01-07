package com.curso.api.services.interfaces;

import com.curso.api.persistence.entities.security.Role;

import java.util.Optional;

public interface IRoleService {
    Optional<Role> findDefaultRole();
}
