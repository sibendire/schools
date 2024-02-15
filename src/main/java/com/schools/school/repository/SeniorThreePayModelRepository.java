package com.schools.school.repository;

import com.schools.school.entity.SeniorThreePayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeniorThreePayModelRepository extends JpaRepository<SeniorThreePayModel,Long> {
    @Query("SELECT r FROM SeniorThreePayModel r WHERE LOWER(r.firstName) LIKE %:keyword% OR LOWER(r.term) LIKE %:keyword%")
    List<SeniorThreePayModel> search(String keyword);
}
