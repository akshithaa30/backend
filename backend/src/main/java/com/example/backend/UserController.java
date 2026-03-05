package com.example.backend;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UserController 
{

    @Autowired
    UserRepository userRepo;

    // REGISTER
    @GetMapping("/demo")
    String demo()
    {
        return "Iam good how are you..";
    }
    
    @GetMapping("/users")
public List<Users> getAllUsers() {
    return userRepo.findAll();
}

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Users user) {
        Users u=this.userRepo.findByEmail(user.getEmail());
        if(u!=null)
        {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        this.userRepo.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body("User Registration successful");
    }
}