package com.schools.school.repository;


import com.schools.school.entity.SeniorFourPayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeniorFourPayModelRepository extends JpaRepository<SeniorFourPayModel,Long> {
    @Query("SELECT f FROM SeniorFourPayModel f WHERE LOWER(f.firstName) LIKE %:keyword% OR LOWER(f.minName) LIKE %:keyword%")
    List<SeniorFourPayModel> search(String keyword);
}
