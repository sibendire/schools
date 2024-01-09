package com.schools.school.entity;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUpload {
    public static void saveFile(String fileUploadDir, String fileName, MultipartFile multipartFile) throws IOException {
        Path upLoadPath = Paths.get(fileUploadDir);
        if (!Files.exists(upLoadPath)){
            Files.createDirectories(upLoadPath);
        }
        try(InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = upLoadPath.resolve(fileName);
            Files.copy(inputStream,filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("could not save the file"+ fileName, e);
        }
    }
}
