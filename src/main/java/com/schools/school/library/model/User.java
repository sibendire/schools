package com.schools.school.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(length = 100, nullable = false)
    private String userName;

    @Column(length = 100, nullable = false)
    private String userAddress;

    @Size(max=10, min = 10, message = "phone number should be 10 Digits")
    @Pattern(regexp = "^[6-9][0-9]*$", message = "please Enter Valid Mobile Number")
    private String userContact;

    @Email(message = "Please provide a valid email address")
    @Column(unique = true)
    private String userEmail;

@JsonIgnore
@OneToMany(mappedBy = "user")
    private List<Book> bookList = new ArrayList<>();


}
