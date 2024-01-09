package com.schools.school.service.serviceImpl;

import com.schools.school.service.FileStorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@Service
public class LocalFileStorageService implements FileStorageService {
    @Value("${file.upload-dir}")
    private String uploadDir;  // Set this in your application.properties or application.yml

    @Override
    public void saveFile(String fileName, MultipartFile file) {
        try {
            Path uploadPath = Paths.get(uploadDir);

            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            Path filePath = uploadPath.resolve(fileName);
            FileCopyUtils.copy(file.getBytes(), filePath.toFile());
        } catch (IOException e) {
            // Handle the exception (e.g., log or throw a custom exception)
            e.printStackTrace();
        }
    }
}
