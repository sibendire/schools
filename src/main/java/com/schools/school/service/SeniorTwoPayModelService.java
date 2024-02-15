package com.schools.school.service;


import com.schools.school.entity.SeniorTwoPayModel;

import java.util.List;

public interface SeniorTwoPayModelService {
    void saveSeniorTwoFee(SeniorTwoPayModel seniorTwoPayModel);
    List<SeniorTwoPayModel> allSeniorStudentPaid(String two);
}
