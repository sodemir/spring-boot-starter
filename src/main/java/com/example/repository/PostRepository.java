package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Axe on 27.01.2017.
 */
public interface PostRepository extends JpaRepository<User, Long> {
}
