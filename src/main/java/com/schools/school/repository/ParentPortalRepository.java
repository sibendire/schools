package com.schools.school.repository;

import com.schools.school.entity.ParentPortal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentPortalRepository extends JpaRepository<ParentPortal,Long> {
    ParentPortal getReferenceById(Long id);
}
