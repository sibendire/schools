package com.schools.school.repository;

import com.schools.school.entity.SeniorOnePayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeniorOnePayModelRepository extends JpaRepository<SeniorOnePayModel, Long> {
    @Query("SELECT o FROM SeniorOnePayModel o WHERE LOWER(o.firstName) LIKE %:keyword% OR LOWER(o.classRoom) LIKE %:keyword%")
    List<SeniorOnePayModel> search(String keyword);
}
