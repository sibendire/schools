package com.schools.school.repository;

import com.schools.school.entity.FeesPayment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FeesPaymentRepository extends JpaRepository<FeesPayment,Long> {
    List<FeesPayment> findByFirstNameAndMinNameAndLastName(String firstName, String minName, String lastName);
}
