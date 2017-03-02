package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Created by Axe on 27.01.2017.
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}