package com.schools.school.service.serviceImpl;

import com.schools.school.entity.Library;
import com.schools.school.repository.LibraryRepository;
import com.schools.school.service.LibraryService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return libraryRepository.findAll();
    }

    @Override
    public Library getBookById(Long id) {
        return libraryRepository.findById(id).get();
    }

    @Override
    public List<Library> getListBooksBorrowed() {
        return libraryRepository.findAll();
    }

    @Override
    public void deleteBookById(Long id) {
        if(!libraryRepository.existsById(id)){
            throw new IllegalArgumentException("Book does not exist in the Library!");
        }
        else {
            libraryRepository.deleteById(id);
        }

    }

    @Override
    public Library updateBookById(@PathVariable Long id) {
        return libraryRepository.findById(id).get();
    }
}
