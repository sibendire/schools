package com.schools.school.controller;

import com.schools.school.entity.Library;
import com.schools.school.service.LibraryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        return "redirect:available_books";
    }
}
