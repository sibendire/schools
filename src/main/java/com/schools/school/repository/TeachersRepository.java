package com.schools.school.repository;

import com.schools.school.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers, Long> {
    @Query("SELECT t FROM Teachers t WHERE LOWER(t.firstName) LIKE %:keyword% OR LOWER(t.midName) LIKE %:keyword%")
    List<Teachers> search(String keyword);

//    Teachers findByName();
}
