package com.schools.school.service.serviceImpl;

import com.schools.school.entity.StudentRegistration;
import com.schools.school.repository.StudentRegistrationRepository;
import com.schools.school.service.StudentRegistrationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
@Transactional
public class StudentRegistrationServiceImpl implements StudentRegistrationService {

    private final StudentRegistrationRepository studentRegistrationRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentRegistrationServiceImpl.class);


    public StudentRegistrationServiceImpl(StudentRegistrationRepository studentRegistrationRepository) {
        this.studentRegistrationRepository = studentRegistrationRepository;
    }

    @Override
    public StudentRegistration saveStudentInformation(StudentRegistration studentRegistration) {
        // Add validation checks, business logic, and error handling if needed
        return studentRegistrationRepository.save(studentRegistration);
    }

    @Override
    public List<StudentRegistration> getAllStudents(String keyword) {
        if (keyword != null){
           return studentRegistrationRepository.search(keyword);
        }
        return(List<StudentRegistration>) studentRegistrationRepository.findAll();
    }

    @Override
    public StudentRegistration updateStudentRecord(Long id) {
        return studentRegistrationRepository.save(updateStudentRecord(id));
    }


    @Override
    public StudentRegistration getStudentById(Long id) {
        return studentRegistrationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student record with ID " + id + " not found."));
    }

    @Override
    public boolean deleteStudentRecordById(Long id) {
        if (studentRegistrationRepository.existsById(id)) {
            studentRegistrationRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean existsById(Long id) {
        return studentRegistrationRepository.existsById(id);
    }

    @Override
    public List<StudentRegistration> getByGender(String studentGender) {
        // Validate input
        if (studentGender == null || studentGender.trim().isEmpty()) {
            LOGGER.error("Invalid gender value provided: {}", studentGender);
            throw new IllegalArgumentException("Invalid gender value provided");
        }

        try {
            List<StudentRegistration> students = studentRegistrationRepository.findByStudentGender(studentGender);

            // Log retrieval success and the number of students retrieved
            LOGGER.info("Retrieved {} students for gender: {}", students.size(), studentGender);

            return students;
        } catch (Exception e) {
            // Log error and rethrow a more specific exception
            LOGGER.error("Error retrieving students by gender: {}", studentGender, e);
            throw new IllegalArgumentException("Error retrieving students by gender: " + studentGender, e);
        }
    }

//    @Override
//    public List<StudentRegistration> search(String keyword) {
//        if (keyword != null){
//            return studentRegistrationRepository.search(keyword);
//        }
//        return null;
//    }


}
