package com.schools.school.library.controller;

import com.schools.school.library.model.Book;
import com.schools.school.library.service.BookIssueReturnImpl;
import com.schools.school.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    @Autowired
    BookIssueReturnImpl bookIssueReturnImpl;
    /* get all books API */
    @GetMapping("all")
    public ResponseEntity<List<Book>>getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }
    /* get a book by id API */
@GetMapping("/book/{id}")
    public Optional<Book> getById(@PathVariable("id") Integer bookId){
        return bookService.findById(bookId);
    }

    /* add book API */
@PostMapping("/add")
    public ResponseEntity<Book> add(@RequestBody Book book){
        return new ResponseEntity<>(bookService.add(book), CREATED);
    }

    /* update a book API */

    @PutMapping("/update")
    public ResponseEntity<Book> update(@RequestBody Book theBook){

        return new ResponseEntity<>(bookService.update(theBook),OK);
    }
    /* delete book API */
    @DeleteMapping("/book/delete/{id}")
    public void delete(@PathVariable("id") Integer bookId){

        bookService.delete(bookId);
    }



    /* Issue book API */
    @PostMapping("/bookIssue/{userId}")
    public ResponseEntity<LocalDate> bookIssueControlHandler(
@PathVariable("userId") Integer userId,
@RequestParam String bookName){
        LocalDate date=bookIssueReturnImpl.issueBook(bookName, userId);
        return new ResponseEntity<LocalDate>(date, HttpStatus.OK);
    }

    /* Return book API */
    @PostMapping("/bookReturn/{userId}/{bookId}")
    public ResponseEntity<Integer> booReturnControlHandler(
            @PathVariable("userId") Integer userId,
            @PathVariable("bookId") Integer bookId){

Integer Response=bookIssueReturnImpl.returnBook( userId, bookId);
return new ResponseEntity<Integer>(Response,HttpStatus.OK);

    }
}
