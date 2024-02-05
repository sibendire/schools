package com.schools.school.library.service;

import com.schools.school.library.model.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book>getAllBooks();
    Book add(Book book);
    Optional<Book> findById(Integer bookId);

    void delete(Integer bookId);

    Book update(Book book);
}
