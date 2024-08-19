package com.example.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.User;
import com.example.repository.UserRepository;

import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserRepository userRepository;

    public void registerUser(User user){
        userRepository.save(user);
    }

    public void showAllUser(){
        userRepository.findAll();
    }

    @Override
    public User getUserById(int idUser) {
        Optional<User> user = userRepository.findById(idUser);
        User getUser = user.get();
        return getUser;
    }
    
}
