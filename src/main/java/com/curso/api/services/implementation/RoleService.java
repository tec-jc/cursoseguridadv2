package com.curso.api.services.implementation;

import com.curso.api.persistence.entities.security.Role;
import com.curso.api.persistence.repositories.security.IRoleRepository;
import com.curso.api.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Value("${security.default.role}")
    private String defaultRole;
    @Override
    public Optional<Role> findDefaultRole() {
        return roleRepository.findByName(defaultRole);
    }
}
