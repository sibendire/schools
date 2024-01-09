package com.schools.school.repository;

import com.schools.school.entity.SeniorThree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorThreeRepository extends JpaRepository<SeniorThree,Long> {
}
