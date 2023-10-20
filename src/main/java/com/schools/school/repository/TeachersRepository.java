package com.schools.school.repository;

import com.schools.school.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeachersRepository extends JpaRepository<Teachers,Long> {
}
