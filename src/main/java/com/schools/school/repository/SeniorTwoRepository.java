package com.schools.school.repository;

import com.schools.school.entity.SeniorTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SeniorTwoRepository extends JpaRepository<SeniorTwo,Long> {
    @Query("SELECT s FROM SeniorTwo s WHERE LOWER(s.studentFirstName) LIKE %:keyword% OR LOWER(s. studentLastName) LIKE %:keyword%")
    List<SeniorTwo> search(String keyword);
}
