package com.example.TS01135_java5OnTap.repository;

import com.example.TS01135_java5OnTap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByIdOrNameContainingIgnoreCase(Integer id, String name);
}

