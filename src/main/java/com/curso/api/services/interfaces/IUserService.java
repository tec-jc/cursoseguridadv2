package com.curso.api.services.interfaces;

import com.curso.api.dtos.user.SaveUser;
import com.curso.api.persistence.entities.User;

import java.util.Optional;

public interface IUserService {
    User registerOneCustomer(SaveUser newUser);

    Optional<User> findOneByUsername(String username);
}
