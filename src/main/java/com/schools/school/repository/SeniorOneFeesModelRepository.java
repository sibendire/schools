package com.schools.school.repository;

import com.schools.school.entity.FeesPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorOneFeesModelRepository extends JpaRepository<FeesPayment, Long> {
}
