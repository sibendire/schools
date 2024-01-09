package com.schools.school.repository;

import com.schools.school.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers,Long> {
//    Teachers findByName();
}
