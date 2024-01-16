package com.schools.school.library.service;

import com.schools.school.library.exception.BookException;
import com.schools.school.library.model.Book;
import com.schools.school.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookService implements IBookService{
    private final BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book add(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer bookId) {
        return Optional.ofNullable(bookRepository.findById(bookId)
                .orElseThrow(()->new BookException("no book found with the id:" +bookId)));
    }

    @Override
    public void delete(Integer bookId) {
        Optional<Book> theBook=findById(bookId);
        theBook.ifPresent(book->bookRepository.deleteById(book.getBookId()));

    }

    @Override
    public Book update(Book book) {

        return bookRepository.save(book);
    }
}
