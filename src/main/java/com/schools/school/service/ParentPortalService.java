package com.schools.school.service;

import com.schools.school.entity.ParentPortal;

import java.util.List;

public interface ParentPortalService {
    ParentPortal saveParent(ParentPortal parentPortal);


    ParentPortal updateParentById(Long id);

    ParentPortal messageParentById(Long id);

    ParentPortal parentViewStudentPerformanceById(Long id);

    ParentPortal messageAllParents(ParentPortal parentPortal);

    List<ParentPortal> getAllParents();

    void deleteParentById(Long id);

    ParentPortal getParentById(Long id);
}
