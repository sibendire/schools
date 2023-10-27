package com.schools.school.controller;

import com.schools.school.entity.ParentPortal;
import com.schools.school.entity.StudentRegistration;
import com.schools.school.service.ParentPortalService;
import com.schools.school.service.StudentRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentRegistrationController {
    private final StudentRegistrationService studentRegistrationService;
    private final ParentPortalService parentPortalService;

    public StudentRegistrationController(StudentRegistrationService studentRegistrationService, ParentPortalService parentPortalService) {
        this.studentRegistrationService = studentRegistrationService;
        this.parentPortalService = parentPortalService;
    }

    @GetMapping("/api")
    public String home() {
        return "home";
    }

    @GetMapping("/studentForm")
    public String showStudentForm(Model model) {
        model.addAttribute("student", new StudentRegistration());
        return "students";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute("student") StudentRegistration studentRegistration) {
        studentRegistrationService.saveStudentInformation(studentRegistration);
        return "redirect:/api/student/list"; // Redirect to the list of students
    }

    @GetMapping("/api/student/list") // Change the URL path
    public String listStudentRegistered(Model model) {
        model.addAttribute("students", studentRegistrationService.getAllStudents());
        return "student_List";
    }

    @GetMapping("/student/new")
    public String createStudentForm(Model model) {
        // Create the object
        StudentRegistration studentRegistration = new StudentRegistration();
        model.addAttribute("students", studentRegistration);
        return "new_student";

    }

    @RequestMapping("/api/student/edit/{id}")
    public String editStudentInformation(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentRegistrationService.getStudentById(id));
        return "edit_student";

    }

    @RequestMapping("/api/student/update/{id}")
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
        existingStudent.setStudentGender(studentRegistration.getStudentGender());
        existingStudent.setStudentClass(studentRegistration.getStudentClass());
        existingStudent.setStudentHealthRecord(studentRegistration.getStudentHealthRecord());
        existingStudent.setStudentPhoto(studentRegistration.getStudentPhoto());
        existingStudent.setStudentHomeAddress(studentRegistration.getStudentHomeAddress());
        existingStudent.setStudentSubCounty(studentRegistration.getStudentSubCounty());
        existingStudent.setStudentDistrict(studentRegistration.getStudentDistrict());

        studentRegistrationService.updateStudentRecords(existingStudent);
        return "redirect:/student";
    }

    @GetMapping("/api/student/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        if (!studentRegistrationService.existsById(id)) {
            throw new IllegalArgumentException("student not found by the id");
        }
        studentRegistrationService.deleteStudentRecordById(id);
        return "redirect:/students";
    }

    @GetMapping("/gender")
    public String getStudentByGender() {
        studentRegistrationService.getByGender();
        return "student_sex";
    }

    @GetMapping("/parentForm")
    public String showParentForm(Model model) {
        model.addAttribute("parent", new ParentPortal());
        return "parents";
    }

    @PostMapping("saveParent")
    public String saveParentInformation(@ModelAttribute("parent") ParentPortal parentPortal) {
        parentPortalService.saveParent(parentPortal);
        return "redirect:/api/parent/list";

    }

    @GetMapping("/api/parent/list")
    public String listParents(Model model) {
        model.addAttribute("parents", parentPortalService.getAllParents());
        return "parent_list";
    }


}
