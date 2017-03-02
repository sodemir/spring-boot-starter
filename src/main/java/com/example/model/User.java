package com.example.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Axe on 25.01.2017.
 */
@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    User() { //jpa only
    }

    public User(String name) {
        this.name = name;
    }

}
