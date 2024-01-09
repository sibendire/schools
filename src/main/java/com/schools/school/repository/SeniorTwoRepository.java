package com.schools.school.repository;

import com.schools.school.entity.SeniorTwo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeniorTwoRepository extends JpaRepository<SeniorTwo,Long> {
}
