package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorTwo;
import com.schools.school.repository.SeniorTwoRepository;
import com.schools.school.service.SeniorTwoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorTwoServiceImpl implements SeniorTwoService {
    @Autowired
    private final SeniorTwoRepository seniorTwoRepository;

    public SeniorTwoServiceImpl(SeniorTwoRepository seniorTwoRepository) {
        this.seniorTwoRepository = seniorTwoRepository;
    }

    @Override
    public void saveToSeniorTwo(SeniorTwo seniorTwo) {
        seniorTwoRepository.save(seniorTwo);

    }

    @Override
    public List<SeniorTwo> getAllSeniorList() {
        return seniorTwoRepository.findAll();
    }
}
