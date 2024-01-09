package com.schools.school.repository;

import com.schools.school.entity.StudentRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRegistrationRepository extends JpaRepository<StudentRegistration, Long> {

    @Query("SELECT s FROM StudentRegistration s WHERE LOWER(s.studentFirstName) LIKE %:keyword% OR LOWER(s.studentMidName) LIKE %:keyword%")
    List<StudentRegistration> search(String keyword);

    List<StudentRegistration> findByStudentGender(String studentGender);
}
