package com.schools.school.repository;

import com.schools.school.entity.SeniorThreePayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorThreePayModelRepository extends JpaRepository<SeniorThreePayModel,Long> {
}
