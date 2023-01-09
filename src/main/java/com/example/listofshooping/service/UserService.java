package com.example.listofshooping.service;

import com.example.listofshooping.model.entity.User;
import com.example.listofshooping.model.services.UserServiceModel;

public interface UserService {
    void registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsernameAndPassword(String password, String username);

    void loginUser(Long id, String username);

    User findById(Long id);
}
