package com.schools.school.library.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(length = 100, nullable = false)
    private String bookName;

    @Column(length = 100, nullable = false)
    private String bookAuthor;

    @Column(length = 500, nullable = false)
    private String bookPublisher;

    @Column(length = 2500)
    private String bookDescription;

    private LocalDate bookIssueDate;

    private LocalDate bookReturnDate;

    private boolean isIssued = false;

    @ManyToOne
    private User user;

}
