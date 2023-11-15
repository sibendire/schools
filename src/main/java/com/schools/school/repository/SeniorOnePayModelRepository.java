package com.schools.school.repository;

import com.schools.school.entity.SeniorOnePayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorOnePayModelRepository extends JpaRepository<SeniorOnePayModel, Long> {
}
