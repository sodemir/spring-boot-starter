package com.example.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import java.util.Optional;

/**
 * Created by Axe on 31.01.2017.
 */
public class BaseRepositoryImpl<T> {
//        extends SimpleJpaRepository<T, Long> implements BaseRepository<T> {
//
//    public BaseRepositoryImpl(JpaEntityInformation entityInformation, EntityManager entityManager) {
//        super(entityInformation, entityManager);
//    }
//
//    @Override
//    public Optional<T> findOneOptional(Long id) {
//        return null;
//    }
}
