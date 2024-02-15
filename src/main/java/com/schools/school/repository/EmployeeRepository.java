package com.schools.school.repository;

import com.schools.school.entity.Employees;
import com.schools.school.entity.SeniorTwoPayModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface EmployeeRepository extends JpaRepository<Employees, Long> {

    @Query("SELECT e FROM Employees e WHERE LOWER(e.firstName) LIKE %:keyword% OR LOWER(e.otherName) LIKE %:keyword%")
    List<Employees> search(String keyword);
}
