package com.boleg.crud_pro.dao;

import com.boleg.crud_pro.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(Long id);

    public void deleteUserById(Long id);

    public User getUserByEmail(String email);
}
