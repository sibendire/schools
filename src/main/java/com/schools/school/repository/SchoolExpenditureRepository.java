package com.schools.school.repository;

import com.schools.school.entity.SchoolExpenditure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolExpenditureRepository extends JpaRepository<SchoolExpenditure, Long> {
}
