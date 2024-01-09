package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorOnePayModel;
import com.schools.school.repository.SeniorOnePayModelRepository;
import com.schools.school.service.SeniorOnePayModelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class SeniorOnePayModelServiceImpl implements SeniorOnePayModelService {
    @Autowired
    private final SeniorOnePayModelRepository seniorOnePayModelRepository;


    @Override
    public SeniorOnePayModel saveSeniorOneFee(SeniorOnePayModel seniorOnePayModel) {
        return seniorOnePayModelRepository.save(seniorOnePayModel);
    }

    @Override
    public List<SeniorOnePayModel> allSeniorStudentPaid() {
        return seniorOnePayModelRepository.findAll();
    }
}