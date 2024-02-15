package com.schools.school.repository;

import com.schools.school.entity.SeniorTwoPayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface SeniorTwoPayModelRepository extends JpaRepository<SeniorTwoPayModel, Long > {
    @Query("SELECT w FROM SeniorTwoPayModel w WHERE LOWER(w.firstName) LIKE %:keyword% OR LOWER(w.lastName) LIKE %:keyword%")
    List<SeniorTwoPayModel> search(String keyword);
}
