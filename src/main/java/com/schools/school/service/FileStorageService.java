package com.schools.school.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
    void saveFile(String fileName, MultipartFile file);
}