package com.schools.school.entity;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    @Column(nullable = false, unique = true, length = 45)
    private String email;
    private String department;
    private double salary;
    private String amountWords;
    private double balance;

}
