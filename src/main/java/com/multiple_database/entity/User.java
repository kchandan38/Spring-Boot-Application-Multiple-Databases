package com.multiple_database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private String city;
    private String address;

}
