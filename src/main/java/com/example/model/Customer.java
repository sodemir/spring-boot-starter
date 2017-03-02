package com.example.model;

import com.example.infrastructure.jpa.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;

/**
 * Created by Axe on 25.01.2017.
 */
@Entity
@Getter
@ToString
@AllArgsConstructor
public class Customer extends AbstractEntity {

    String firstname, lastname;

    protected Customer() {
        this.firstname = null;
        this.lastname = null;
    }
}