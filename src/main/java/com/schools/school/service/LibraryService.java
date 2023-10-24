package com.schools.school.service;

import com.schools.school.entity.Library;

import java.util.List;

public interface LibraryService {
    Library saveBook(Library library);
    List<Library> getAllBook();
    Library getBookById(Long id);
    List<Library> getListBooksBorrowed();
    void deleteBookById(Long id);
    Library updateBookById(Long id);
}
