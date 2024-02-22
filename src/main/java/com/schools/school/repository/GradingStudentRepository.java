package com.schools.school.repository;

import com.schools.school.entity.GradingStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface GradingStudentRepository extends JpaRepository<GradingStudent,Long> {

    @Query("SELECT g FROM GradingStudent g WHERE LOWER(g.studentFirstName) LIKE %:keyword% OR LOWER(g.studentLastName) LIKE %:keyword%")
    List<GradingStudent> search(String keyword);
}
