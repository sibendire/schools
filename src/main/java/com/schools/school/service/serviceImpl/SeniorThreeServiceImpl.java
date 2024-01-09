package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorThree;
import com.schools.school.repository.SeniorThreeRepository;
import com.schools.school.service.SeniorThreeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorThreeServiceImpl implements SeniorThreeService {
    private final SeniorThreeRepository seniorThreeRepository;

    public SeniorThreeServiceImpl(SeniorThreeRepository seniorThreeRepository) {
        this.seniorThreeRepository = seniorThreeRepository;
    }

    @Override
    public void saveToSeniorThree(SeniorThree seniorThree) {
        seniorThreeRepository.save(seniorThree);

    }

    @Override
    public List<SeniorThree> getAllSeniorList() {
        return seniorThreeRepository.findAll();
    }
}
