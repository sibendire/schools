package com.schools.school.service;

import com.schools.school.entity.StudentRegistration;
import java.util.List;

public interface StudentRegistrationService {

    // Create a new student record
    StudentRegistration saveStudentInformation(StudentRegistration studentRegistration);

    // Retrieve all student records
    List<StudentRegistration> getAllStudents();

    // Update an existing student record
    StudentRegistration updateStudentRecord(Long id);

    // Retrieve a student record by ID
    StudentRegistration getStudentById(Long id);

    // Delete a student record by ID
    boolean deleteStudentRecordById(Long id);

    // Check if a student record with given ID exists
    boolean existsById(Long id);

    List<StudentRegistration> getByGender(String studentGender);

}
