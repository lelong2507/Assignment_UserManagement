package com.example.service;

import com.example.model.User;

public interface UserService{
    void registerUser(User user);
    void showAllUser();
    User getUserById(int idUser);
}