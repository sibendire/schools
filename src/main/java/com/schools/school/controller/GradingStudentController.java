package com.schools.school.controller;

import com.schools.school.entity.GradingStudent;
import com.schools.school.service.GradingStudentService;
import com.schools.school.service.SeniorOneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GradingStudentController {
    private final GradingStudentService gradingStudentService;
    private final SeniorOneService seniorOneService;

    @Autowired
    public GradingStudentController(GradingStudentService gradingStudentService, SeniorOneService seniorOneService) {
        this.gradingStudentService = gradingStudentService;
        this.seniorOneService = seniorOneService;
    }

    @GetMapping("/markForm")
    public String marksForm(Model model) {
        model.addAttribute("marks", new GradingStudent());
        return "mark";
    }


    @PostMapping("/api/save/marks")
    public String saveMarks(@ModelAttribute("marks") GradingStudent gradingStudent) {
        gradingStudentService.saveStudentGrade(gradingStudent);
        return "redirect:/total/marks";
    }
//    @GetMapping("/total/marks")
//    public  String getTotalMark(){
//     gradingStudentService.calculateGrade();
//        return "mark_list";
//    }


    @GetMapping("/{studentId}/total-marks")
    public String getTotalMarks(@PathVariable Long studentId) {
        GradingStudent student = gradingStudentService.findById(studentId);

        if (student != null) {
            gradingStudentService.getTotalMarks(student);
        } else {
            // Handle student not found
            return "student marks not found";
        }
        return "total";
    }

    @GetMapping("/{studentId}/chemistry-grade")
    public String getChemistryGrade(@PathVariable Long studentId) {
        GradingStudent student = gradingStudentService.findById(studentId);

        if (student != null) {
            gradingStudentService.calculateGrade(student);
            student.getChemistry();
        } else {
            // Handle student not found
            return "Student not found";
        }
        return "chem";
    }

    @PostMapping("/sava/update")
    public String updateStudentMark(@PathVariable Long id, @ModelAttribute("marks") GradingStudent
            gradingStudent, Model model) {
        GradingStudent existingMarks = gradingStudentService.findById(id);
        existingMarks.setId(id);
        existingMarks.setFrench(gradingStudent.getFrench());
        existingMarks.setCre(gradingStudent.getCre());
        existingMarks.setBios(gradingStudent.getBios());
        existingMarks.setEnglish(gradingStudent.getEnglish());
        existingMarks.setChemistry(gradingStudent.getChemistry());
        gradingStudentService.updateStudentMarks(existingMarks);
        return "marks_update_list";

    }

    @GetMapping("/delete")
    public String deleteMarksById(@PathVariable Long id) {
        gradingStudentService.deleteMarksById(id);
        return "redirect:/marks_update_list";
    }

}