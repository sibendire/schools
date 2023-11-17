package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorOne;
import com.schools.school.repository.SeniorOneRepository;
import com.schools.school.service.SeniorOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeniorOneServiceImpl implements SeniorOneService {
    @Autowired
    SeniorOneRepository seniorOneRepository;

    @Override
    public void saveToSeniorOne(SeniorOne seniorOne) {
        seniorOneRepository.save(seniorOne);
    }

    @Override
    public List<SeniorOne> getAllSeniorList() {
        return seniorOneRepository.findAll();
    }
}
