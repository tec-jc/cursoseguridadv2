package com.curso.api.services.implementation;

import com.curso.api.dtos.user.SaveUser;
import com.curso.api.exceptions.InvalidPasswordException;
import com.curso.api.exceptions.ObjectNotFoundException;
import com.curso.api.persistence.entities.security.Role;
import com.curso.api.persistence.entities.security.User;
import com.curso.api.persistence.repositories.security.IUserRepository;
import com.curso.api.services.interfaces.IRoleService;
import com.curso.api.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRoleService roleService;

    @Override
    public User registerOneCustomer(SaveUser newUser) {
        validatePassword(newUser);

        User user = new User();
        user.setPassword(passwordEncoder.encode(newUser.getPassword()));
        user.setUsername(newUser.getUsername());
        user.setName(newUser.getName());

        Role defaultRole = roleService.findDefaultRole()
                .orElseThrow(() -> new ObjectNotFoundException("Role not found. Default Role"));
        user.setRole(defaultRole);

        return userRepository.save(user);
    }

    @Override
    public Optional<User> findOneByUsername(String username) {

        return userRepository.findByUsername(username);
    }

    private void validatePassword(SaveUser dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Complete los datos");
        }

        if(!dto.getPassword().equals(dto.getRepeatedPassword())){
            throw new InvalidPasswordException("Las claves no coinciden");
        }
    }
}
