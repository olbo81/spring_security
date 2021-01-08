package com.boleg.crud_pro.service;

import com.boleg.crud_pro.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

    public User getByEmail(String email);
}
