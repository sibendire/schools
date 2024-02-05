package com.schools.school.library.repository;

import com.schools.school.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Integer> {


public Optional<Book>findByBookName(String bookName);
}
