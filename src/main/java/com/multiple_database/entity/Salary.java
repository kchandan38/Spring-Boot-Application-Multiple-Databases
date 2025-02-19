package com.multiple_database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Salary {

    @Id
    @GeneratedValue
    private int id;
    private String firstName;
    private String lastName;
    private Long salary;

}
