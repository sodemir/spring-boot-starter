package com.example.repository;

import com.example.model.User;
import org.springframework.data.repository.Repository;

/**
 * Created by Axe on 27.01.2017.
 */
public interface LookupRepository extends Repository<User, Long> {
    User findById(long id);
}
