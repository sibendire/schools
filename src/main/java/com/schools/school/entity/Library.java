package com.schools.school.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Lib")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookTitle;
    private String authorName;
    private Date yearOfPublicity;
//    private List<Library> books;

    public Library(Long id, String bookTitle, String authorName, Date yearOfPublicity) {
        this.id = id;
        this.bookTitle = bookTitle;
        this.authorName = authorName;
        this.yearOfPublicity = yearOfPublicity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Date getYearOfPublicity() {
        return yearOfPublicity;
    }

    public void setYearOfPublicity(Date yearOfPublicity) {
        this.yearOfPublicity = yearOfPublicity;
    }
}
