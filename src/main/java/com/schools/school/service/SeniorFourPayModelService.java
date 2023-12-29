package com.schools.school.service;

import com.schools.school.entity.SeniorFourPayModel;


import java.util.List;

public interface SeniorFourPayModelService {
    void saveSeniorFourFee(SeniorFourPayModel seniorfourPayModel);
    List<SeniorFourPayModel> allSeniorStudentPaid();
}
