package com.schools.school.service.serviceImpl;

import com.schools.school.entity.ParentPortal;
import com.schools.school.repository.ParentPortalRepository;
import com.schools.school.service.ParentPortalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


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
    public ParentPortal updateParentById(Long id) {
        Optional<ParentPortal> optionalParentPortal = parentPortalRepository.findById(id);
        if (optionalParentPortal.isPresent()) {
            ParentPortal parentPortal = optionalParentPortal.get();
            // Update logic here
            return parentPortalRepository.save(parentPortal);
        }
        throw new IllegalArgumentException("Parent with ID " + id + " not found");
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
        public List<ParentPortal> getAllParents(String word) {
            if (word != null ){
                return parentPortalRepository.search(word);
            }
            return(List<ParentPortal>) parentPortalRepository.findAll();
        }

        @Override
        public void deleteParentById(Long id) {
            parentPortalRepository.deleteById(id);

        }

    @Override
    public ParentPortal getParentById(Long id) {
        return parentPortalRepository.findById(id).get();
    }
}

