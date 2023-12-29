package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorFourPayModel;
import com.schools.school.repository.SeniorFourPayModelRepository;
import com.schools.school.service.SeniorFourPayModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class SeniorFourPayModelServiceImpl implements SeniorFourPayModelService {
    private final SeniorFourPayModelRepository seniorFourPayModelRepository;
    @Override
    public void saveSeniorFourFee(SeniorFourPayModel seniorfourPayModel) {
        seniorFourPayModelRepository.save(seniorfourPayModel) ;
    }

    @Override
    public List<SeniorFourPayModel> allSeniorStudentPaid() {
        return seniorFourPayModelRepository.findAll();
    }
}
