package com.boleg.crud_pro.service;

import com.boleg.crud_pro.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User saveUser(User user, String[] roles);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User getUserByEmail(String email);

}
