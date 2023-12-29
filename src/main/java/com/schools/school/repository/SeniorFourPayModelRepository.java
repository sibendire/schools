package com.schools.school.repository;


import com.schools.school.entity.SeniorFourPayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeniorFourPayModelRepository extends JpaRepository<SeniorFourPayModel,Long> {
}
