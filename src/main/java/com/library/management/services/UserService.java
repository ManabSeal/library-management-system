package com.library.management.services;

import java.util.List;

import com.library.management.model.User;

public interface UserService {
    int createUser(User user);
    boolean updateUser(User user);
    User getUserById(int userId);
    boolean deleteUser(int userId);
    List<User> getAllUsers();
    boolean userAuth(int userId, String password);
}