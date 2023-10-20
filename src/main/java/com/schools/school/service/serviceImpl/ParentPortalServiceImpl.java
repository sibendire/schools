package com.schools.school.service.serviceImpl;

import com.schools.school.entity.ParentPortal;
import com.schools.school.repository.ParentPortalRepository;
import com.schools.school.service.ParentPortalService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
    public class ParentPortalServiceImpl implements ParentPortalService {
        private final ParentPortalRepository parentPortalRepository;

        public ParentPortalServiceImpl(ParentPortalRepository parentPortalRepository) {
            this.parentPortalRepository = parentPortalRepository;
        }

        @Override
        public ParentPortal saveParent(ParentPortal parentPortal) {
            return parentPortalRepository.save(parentPortal);
        }

        @Override
        public ParentPortal updateParent(ParentPortal parentPortal) {
            return parentPortalRepository.getReferenceById(updateParentById(parentPortal.getId()).getId());
        }

        @Override
        public ParentPortal updateParentById(Long id) {
            return parentPortalRepository.getById(id);
        }

        @Override
        public ParentPortal messageParentById(Long id) {
            return parentPortalRepository.findById(id).get();
        }

        @Override
        public ParentPortal parentViewStudentPerformanceById(Long id) {
            return parentPortalRepository.findById(id).get();
        }

        @Override
        public ParentPortal messageAllParents(ParentPortal parentPortal) {
            return (ParentPortal) parentPortalRepository.findAll();
        }

        @Override
        public List<ParentPortal> getAllParents() {
            return parentPortalRepository.findAll();
        }

        @Override
        public void deleteParentById(Long id) {
            parentPortalRepository.deleteById(id);

        }
    }

