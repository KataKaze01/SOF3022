
package com.example.test.auth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository<Users, String> {
    Optional<Users> findByTen(String ten);
}
