package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorThreePayModel;
import com.schools.school.repository.SeniorThreePayModelRepository;
import com.schools.school.service.SeniorThreePayModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class SeniorThreePayModelServiceImpl implements SeniorThreePayModelService {
    private final SeniorThreePayModelRepository seniorThreePayModelRepository;
    @Override
    public void saveSeniorThreeFee(SeniorThreePayModel seniorThreePayModel) {
         seniorThreePayModelRepository.save(seniorThreePayModel);
    }

    @Override
    public List<SeniorThreePayModel> allSeniorStudentPaid() {
        return seniorThreePayModelRepository.findAll();
    }
}
