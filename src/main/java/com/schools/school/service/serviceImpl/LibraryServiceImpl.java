package com.schools.school.service.serviceImpl;

import com.schools.school.entity.Library;
import com.schools.school.repository.LibraryRepository;
import com.schools.school.service.LibraryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {
    private final LibraryRepository libraryRepository;

    public LibraryServiceImpl(LibraryRepository libraryRepository) {
        this.libraryRepository = libraryRepository;
    }

    @Override
    public Library saveBook(Library library) {
        return libraryRepository.save(library);
    }

    @Override
    public List<Library> getAllBook() {
        return null;
    }

    @Override
    public Library getBookById(Long id) {
        return null;
    }

    @Override
    public List<Library> getListBooksBorrowed() {
        return null;
    }

    @Override
    public void deleteBookById(Long id) {

    }

    @Override
    public Library updateBookById(Long id) {
        return null;
    }
}
