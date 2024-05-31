package com.library.management.services;

import java.util.List;

import com.library.management.exception.UserNotFoundException;
import com.library.management.model.User;
import com.library.management.repository.UserRepository;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl() {
        this.userRepository = new UserRepository();
    }
    
    @Override
    public int createUser(User user) {
        return userRepository.saveUser(user);
    }

    @Override
    public User getUserById(int userId){
    	try {
    		return userRepository.findById(userId);
    	}catch(UserNotFoundException e) {
    		return null;
    	}catch(Exception e) {
    		return null;
    	}
    }

    @Override
    public boolean deleteUser(int userId) {
        return userRepository.deleteUser(userId);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAllUsers();
    }

    @Override
    public boolean updateUser(User user) {
        return userRepository.saveOrUpdateUser(user);
    }

    @Override
    public boolean userAuth(int userId, String password) {
        return userRepository.checkUserAuth(userId, password);
    }
}