package com.schools.school.controller;

import com.schools.school.entity.StudentRegistration;
import com.schools.school.service.StudentRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentRegistrationController {
    private final StudentRegistrationService studentRegistrationService;

    public StudentRegistrationController(StudentRegistrationService studentRegistrationService) {
        this.studentRegistrationService = studentRegistrationService;
    }
    @GetMapping("/api")
    public String home(){
        return "home";
    }
    @GetMapping("/studentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new StudentRegistration());
        return "students";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") StudentRegistration studentRegistration) {
        studentRegistrationService.saveStudentInformation(studentRegistration);
        return "redirect:/students";
    }
    @GetMapping("/api/student")
    public String listStudentRegistered(Model model) {
        model.addAttribute("students", studentRegistrationService.getAllStudents());
        return "students";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model) {
        // Create the object
        StudentRegistration studentRegistration = new StudentRegistration();
        model.addAttribute("students", studentRegistration);
        return "new_student";

    }

    @GetMapping("/api/student/edit/{id}")
    public String editStudentInformation(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRegistrationService.getStudentById(id));
        return "edit_student";

    }

    @GetMapping("/api/student/update/{id}")
    public String updateStudentRecord(@PathVariable Long id, @ModelAttribute("student")
    StudentRegistration studentRegistration, Model model) {
        // get the student record from the database by if exists
        StudentRegistration existingStudent = studentRegistrationService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setStudentFirstName(studentRegistration.getStudentFirstName());
        existingStudent.setStudentMidName(studentRegistration.getStudentMidName());
        existingStudent.setStudentLastName(studentRegistration.getStudentLastName());
        existingStudent.setStudentDateOfBirth(studentRegistration.getStudentDateOfBirth());
        existingStudent.setStudentNationalIdentificationNumberNIN(studentRegistration
                .getStudentNationalIdentificationNumberNIN());
        existingStudent.setStudentNationalIdentificationCardNumber(studentRegistration
                .getStudentNationalIdentificationCardNumber());
        existingStudent.setStudentGender(studentRegistration.getStudentGender());
        existingStudent.setStudentClass(studentRegistration.getStudentClass());
        existingStudent.setStudentHealthRecord(studentRegistration.getStudentHealthRecord());
        existingStudent.setStudentPhoto(studentRegistration.getStudentPhoto());
        existingStudent.setStudentPhoneNumber(studentRegistration.getStudentPhoneNumber());
        existingStudent.setStudentHomeAddress(studentRegistration.getStudentHomeAddress());
        existingStudent.setStudentSubCounty(studentRegistration.getStudentSubCounty());
        existingStudent.setStudentDistrict(studentRegistration.getStudentDistrict());

        studentRegistrationService.updateStudentRecords(existingStudent);
        return "redirect:/student";
    }

    @GetMapping("/api/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentRegistrationService.deleteStudentRecordById(id);
        return "redirect:/students";
    }
    @GetMapping("/gender")
    public String getStudentByGender(){
        studentRegistrationService.getByGender();
        return "student_sex";
    }
}
