package com.schools.school.controller;

import com.schools.school.entity.Library;
import com.schools.school.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class LibraryController {
    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @GetMapping("/api/book_list")
    public String showAddedBook(Model model) {
        model.addAttribute("book", new Library());
        return "available_books";
    }

    @PostMapping("/save_book")
    public String saveBooks(@ModelAttribute("book") Library library) {
        libraryService.saveBook(library);
        return "redirect:/listBooks";
    }

    @GetMapping("/listBooks")
    public String getAllBooks(Model model) {
        List<Library> list = libraryService.getAllBook();
        model.addAttribute("book", list);
        return "allBooks_available";
    }

    @GetMapping("/borrowedBooks")
    public String getBookBorrowed(Model model) {
        List<Library> list = libraryService.getListBooksBorrowed();
        model.addAttribute("book", list);
        return "books_taken";
    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id) {
        libraryService.deleteBookById(id);
        return "recycle_bin";
    }

    @RequestMapping("/edit/{id}")
    public String editBook(@PathVariable("id") long id, Model model) {
        Library library = libraryService.updateBookById(id);
        model.addAttribute("book", library);
        return "redirect:/available_books";
    }
}
