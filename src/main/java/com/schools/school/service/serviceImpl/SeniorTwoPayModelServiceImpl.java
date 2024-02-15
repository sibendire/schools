package com.schools.school.service.serviceImpl;

import com.schools.school.entity.SeniorTwoPayModel;
import com.schools.school.repository.SeniorTwoPayModelRepository;
import com.schools.school.service.SeniorTwoPayModelService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class SeniorTwoPayModelServiceImpl implements SeniorTwoPayModelService {
    private final SeniorTwoPayModelRepository seniorTwoPayModelRepository;
    @Override
    public void saveSeniorTwoFee(SeniorTwoPayModel seniorTwoPayModel) {
         seniorTwoPayModelRepository.save(seniorTwoPayModel);
    }

    @Override
    public List<SeniorTwoPayModel> allSeniorStudentPaid(String two) {
        if (two != null){
            return seniorTwoPayModelRepository.search(two);
        }
        return(List<SeniorTwoPayModel>) seniorTwoPayModelRepository.findAll();
    }
}
