package com.schools.school.service;


import com.schools.school.entity.SeniorThreePayModel;

import java.util.List;

public interface SeniorThreePayModelService {
    void saveSeniorThreeFee(SeniorThreePayModel seniorThreePayModel);
    List<SeniorThreePayModel> allSeniorStudentPaid(String three);
}
