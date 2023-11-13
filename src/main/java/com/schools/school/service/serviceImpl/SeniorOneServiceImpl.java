package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorOne;
import com.schools.school.repository.SeniorOneRepository;
import com.schools.school.service.SeniorOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeniorOneServiceImpl implements SeniorOneService {
    @Autowired
    SeniorOneRepository seniorOneRepository;
    @Override
    public SeniorOne save(SeniorOne seniorOne) {
        return seniorOneRepository.save(seniorOne);
    }
}
