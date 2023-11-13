package com.schools.school.repository;

import com.schools.school.entity.SeniorFour;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorFourRepository extends JpaRepository<SeniorFour,Long> {
}
