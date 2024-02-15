package com.schools.school.service;

import com.schools.school.entity.Teachers;

import java.util.List;

public interface TeachersService {
    Teachers saveTeacher(Teachers teachers);
    List<Teachers> getAllTeachers(String teach);
    //Teachers getTeacherByName(String teachers);
    Teachers updateTeacherById(Long id);
    Teachers getTeacherById(Long id);
    Teachers getTeacherSalaryById(Long id);
    Teachers updateSalaryById(Long id);
    List<Teachers> getAllTeachersSalary();
    boolean deleteTeachersById(Long id);
    long getTeacherBalance(double balance);

    boolean existById(Long id);
}
