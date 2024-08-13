package com.example.shopcamera.Service;


import com.example.shopcamera.Model.User;
import com.example.shopcamera.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.regex.Pattern.matches;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User checkAccount(User user){
        List<User> userList = userRepository.findAll();
        for (User acc : userList){
            if (user.getUsername().equals(acc.getUsername()) && user.getPassword().equals(acc.getPassword())){
                return acc;
            }
        }

        return null;
    }


    public Page<User> getAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return userRepository.findAll(pageable);
    }

    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long userId, User userDetails) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setFullName(userDetails.getFullName());
        user.setAddress(userDetails.getAddress());
        user.setPhoneNumber(userDetails.getPhoneNumber());
        return userRepository.save(user);
    }

    public boolean deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return false;
    }
}