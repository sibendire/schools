package com.schools.school.service;

import com.schools.school.entity.GradingStudent;

public interface GradingStudentService {
    GradingStudent saveStudentGrade(GradingStudent gradingStudent);
    long getTotalMarks(GradingStudent gradingStudent);
    void calculateGrade(GradingStudent gradingStudent);

    GradingStudent findById(Long studentId);
    GradingStudent updateStudentMarks(GradingStudent gradingStudent);
    void deleteMarksById(Long gradingStudent);
}
