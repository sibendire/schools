package com.schools.school.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Employees {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String otherName;
    private String lastName;
    private String email;
    private String department;
    private double salary;
    private String amountWords;
    private double balance;

}
