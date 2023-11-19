package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorFour;
import com.schools.school.repository.SeniorFourRepository;
import com.schools.school.service.SeniorFourService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorFourServiceImpl implements SeniorFourService {
    private final SeniorFourRepository seniorFourRepository;

    public SeniorFourServiceImpl(SeniorFourRepository seniorFourRepository) {
        this.seniorFourRepository = seniorFourRepository;
    }

    @Override
    public void saveToSeniorFour(SeniorFour seniorFour) {
        seniorFourRepository.save(seniorFour);

    }

    @Override
    public List<SeniorFour> getAllSeniorList() {
        return seniorFourRepository.findAll();
    }
}
