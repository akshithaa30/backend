package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users,Integer>
{
   Users findByEmail(String email);

//    Users m1()
//    {
//      return new Users();
//    }
}