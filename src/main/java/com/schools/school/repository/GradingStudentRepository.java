package com.schools.school.repository;

import com.schools.school.entity.GradingStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradingStudentRepository extends JpaRepository<GradingStudent,Long> {
}
