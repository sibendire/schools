//package com.schools.school.entity;
//
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "Lib")
//public class Library {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//    @Column(name = "book_Name")
//    private String bookTitle;
//    @Column(name = "author_Name")
//    private String authorName;
//    @Column(name = "year")
//    private String yearOfPublicity;
////    private List<Library> books;
//
//    public Library(Long id, String bookTitle, String authorName, String yearOfPublicity) {
//        this.id = id;
//        this.bookTitle = bookTitle;
//        this.authorName = authorName;
//        this.yearOfPublicity = yearOfPublicity;
//    }
//
//    public Library() {
//
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getBookTitle() {
//        return bookTitle;
//    }
//
//    public void setBookTitle(String bookTitle) {
//        this.bookTitle = bookTitle;
//    }
//
//    public String getAuthorName() {
//        return authorName;
//    }
//
//    public void setAuthorName(String authorName) {
//        this.authorName = authorName;
//    }
//
//    public String getYearOfPublicity() {
//        return yearOfPublicity;
//    }
//
//    public void setYearOfPublicity(String yearOfPublicity) {
//        this.yearOfPublicity = yearOfPublicity;
//    }
//}
