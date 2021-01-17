package com.boleg.crud_pro.service;

import com.boleg.crud_pro.entity.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUserById(int id);

    public void deleteUserById(int id);

    public User getUserByEmail(String email);

}
