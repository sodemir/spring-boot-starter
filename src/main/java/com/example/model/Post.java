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
public class Post {

    @Id
    @GeneratedValue
    private Long id;

    private String text;

    Post() { //jpa only
    }

    public Post(String text) {
        this.text = text;
    }

}
