package com.schools.school.repository;

import com.schools.school.entity.ParentPortal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParentPortalRepository extends JpaRepository<ParentPortal,Long> {
    ParentPortal getReferenceById(Long id);

    @Query("SELECT p FROM ParentPortal p WHERE LOWER(p.firstName) LIKE %:keyword% OR LOWER(p.midName) LIKE %:keyword%")

    List<ParentPortal> search(String keyword);
}
