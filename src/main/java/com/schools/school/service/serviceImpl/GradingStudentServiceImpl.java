package com.schools.school.service.serviceImpl;

import com.schools.school.entity.GradingStudent;
import com.schools.school.repository.GradingStudentRepository;
import com.schools.school.service.GradingStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradingStudentServiceImpl implements GradingStudentService {
    private final GradingStudentRepository gradingStudentRepository;

    @Autowired
    public GradingStudentServiceImpl(GradingStudentRepository gradingStudentRepository) {
        this.gradingStudentRepository = gradingStudentRepository;
    }

    @Override
    public GradingStudent saveStudentGrade(GradingStudent gradingStudent) {
        return gradingStudentRepository.save(gradingStudent);
    }

    @Override
    public int getTotalMarks(GradingStudent gradingStudent) {
        return gradingStudent.getChemistry() + gradingStudent.getEnglish() +
                gradingStudent.getBios() + gradingStudent.getCre() + gradingStudent.getFrench();
    }

//    @Override
//    public void calculateGrade(GradingStudent gradingStudent) {
//        int totalMarks = getTotalMarks(gradingStudent);
//
//        // Example grading logic (customize based on your grading criteria)
//        String grade;
//        if (totalMarks >= 80) {
//            grade = "A";
//        } else if (totalMarks >= 60) {
//            grade = "B";
//        } else if (totalMarks >= 40) {
//            grade = "C";
//        } else {
//            grade = "F";
//        }
//
//        gradingStudent.setGrade(grade);
//    }
@Override
public void calculateGrade(GradingStudent gradingStudent) {
    int chemistryGrade = calculateSubjectGrade(gradingStudent.getChemistry());
    int englishGrade = calculateSubjectGrade(gradingStudent.getEnglish());
    int biosGrade = calculateSubjectGrade(gradingStudent.getBios());
    int creGrade = calculateSubjectGrade(gradingStudent.getCre());
    int frenchGrade = calculateSubjectGrade(gradingStudent.getFrench());

    // Calculate the overall grade based on the individual subject grades
    double overallGrade = (chemistryGrade + englishGrade + biosGrade + creGrade + frenchGrade) / 5.0;

    // Customize the overall grading logic based on your specific requirements
    String grade;
    if (overallGrade >= 4.5) {
        grade = "A+";
    } else if (overallGrade >= 4.0) {
        grade = "A";
    } else if (overallGrade >= 3.5) {
        grade = "B+";
    } else if (overallGrade >= 3.0) {
        grade = "B";
    } else if (overallGrade >= 2.5) {
        grade = "C+";
    } else if (overallGrade >= 2.0) {
        grade = "C";
    } else {
        grade = "F";
    }

    gradingStudent.setGrade(grade);
}

    private int calculateSubjectGrade(int marks) {
        // Example grading logic for a single subject (customize based on your criteria)
        if (marks >= 80) {
            return 5;  // A
        } else if (marks >= 60) {
            return 4;  // B
        } else if (marks >= 40) {
            return 3;  // C
        } else {
            return 0;  // F
        }
    }


    @Override
    public GradingStudent findById(Long studentId) {
        return gradingStudentRepository.findById(studentId).orElse(null);
    }

    @Override
    public GradingStudent updateStudentMarks(GradingStudent gradingStudent) {
        return gradingStudentRepository.save(gradingStudent);
    }

    @Override
    public void deleteMarksById(Long gradingStudentId) {
        gradingStudentRepository.deleteById(gradingStudentId);
    }

    @Override
    public List<GradingStudent> getAllStudents() {
        return gradingStudentRepository.findAll();
    }

    @Override
    public void calculateGradeForStudent(GradingStudent student) {

    }
}
