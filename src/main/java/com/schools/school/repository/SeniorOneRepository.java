package com.schools.school.repository;

import com.schools.school.entity.SeniorOne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorOneRepository extends JpaRepository<SeniorOne,Long> {
}
