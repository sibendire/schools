package com.schools.school.repository;

import com.schools.school.entity.FeesPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FeesPaymentRepository extends JpaRepository<FeesPayment,Long> {
    List<FeesPayment> findByFirstNameAndMinNameAndLastName(String firstName, String minName, String lastName);

    @Query("SELECT s FROM FeesPayment s WHERE LOWER(s.firstName) LIKE %:keyword% OR LOWER(s.lastName) LIKE %:keyword%")
    List<FeesPayment> search(String keyword);
}
