package com.example.repository;

import com.example.model.Customer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

/**
 * Created by Axe on 31.01.2017.
 */

public interface CustomerRepository extends Repository<Customer, Long> {

    Optional<Customer> findOne(Long id);

    <S extends Customer> S save(S customer);

    Iterable<Customer> findAll();
}
