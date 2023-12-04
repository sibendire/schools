package com.schools.school.service;

import com.schools.school.entity.StudentRegistration;

import java.util.List;

public interface StudentRegistrationService {
    StudentRegistration saveStudentInformation(StudentRegistration studentRegistration);
    List<StudentRegistration> getAllStudents();
    StudentRegistration updateStudentRecords(StudentRegistration studentRegistration);
    StudentRegistration getStudentById(Long id);
    StudentRegistration getStudentRegistrationById(Long id);
    void deleteStudentRecordById(Long id);
    List<StudentRegistration> getByGender(String gender);
   // StudentRegistration getStudentByFirstName(String firstName);

    boolean existsById(Long id);
}
