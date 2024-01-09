package com.schools.school.repository;

import com.schools.school.entity.SeniorTwoPayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SeniorTwoPayModelRepository extends JpaRepository<SeniorTwoPayModel, Long > {
}
