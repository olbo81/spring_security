package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.User;

import java.util.List;

public interface UserDAO {

    List<User> getAllUsers();

    void saveUser(User user);

    User getUserById(Long id);

    void deleteUserById(Long id);

    User getUserByEmail(String email);
}
