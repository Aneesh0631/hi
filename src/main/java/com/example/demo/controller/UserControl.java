package com.example.demo.controller;


import com.example.demo.exception.UsernameAlreadyExist;
import com.example.demo.model.*;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Table;
import java.util.List;

@RequestMapping("/api/v1/Ticketbooking")
@Table(name = "users")
public class UserControl {
    @Autowired
    public UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        User user = userRepository.findById(id).orElseThrow(()->new UsernameAlreadyExist("User name already exist"));
        return ResponseEntity.ok(user);
    }
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id , @RequestBody User userDetails){
        User updateUser = userRepository.findById(id).orElseThrow(()->new UsernameAlreadyExist("User not found " + id + " go to login page"));

        updateUser.setName(userDetails.getName());
updateUser.setPassword(userDetails.getPassword());
updateUser.setPhonenumber(userDetails.getPhonenumber());

userRepository.save(updateUser);
return ResponseEntity.ok(updateUser);
    }

}
