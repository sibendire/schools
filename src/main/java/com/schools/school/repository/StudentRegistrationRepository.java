package com.schools.school.repository;

import com.schools.school.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration,Long> {
    List<StudentRegistration> findByStudentGender(String studentGender);

//    StudentRegistration findByFirstName();
}
