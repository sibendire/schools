package com.schools.school.controller;

import com.schools.school.entity.ParentPortal;
import com.schools.school.entity.SeniorOne;
import com.schools.school.entity.StudentRegistration;
import com.schools.school.service.ParentPortalService;
import com.schools.school.service.SeniorOneService;
import com.schools.school.service.StudentRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentRegistrationController {
    @Autowired
    private final SeniorOneService seniorOneService;
    @Autowired
    private final StudentRegistrationService studentRegistrationService;
    private final ParentPortalService parentPortalService;
    private List<StudentRegistration> selectedStudent  = new ArrayList<StudentRegistration>();

    public StudentRegistrationController(SeniorOneService seniorOneService, StudentRegistrationService studentRegistrationService, ParentPortalService parentPortalService) {
        this.seniorOneService = seniorOneService;
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
    public String editStudentInformation(@PathVariable  String id, Model model) {
        try {
            Long studentId = Long.parseLong(id);
            model.addAttribute("student", studentRegistrationService.getStudentById(studentId));
            return "edit_student";
        }catch (NumberFormatException e){
            return "message";
        }
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
        model.addAttribute("parents", new ParentPortal());
        return "parents";
    }

    @PostMapping("saveParent")
    public String saveParentInformation(@ModelAttribute("parents") ParentPortal parentPortal) {
        parentPortalService.saveParent(parentPortal);
        return "redirect:/api/parent/list";

    }

    @GetMapping("/api/parent/list")
    public String listParents(Model model) {
        model.addAttribute("parents", parentPortalService.getAllParents());
        return "parent_list";
    }
    @GetMapping("/seniorOne")
    public String getSeniorOne(Model model){
        List<SeniorOne> list = seniorOneService.getAllSeniorList();
       model.addAttribute("student",list);
        return "senior_List";
    }
    @RequestMapping ("/saveToS1/{id}")
    public String getSeniorOneList(@PathVariable("id") Long id){
        StudentRegistration studentRegistration = studentRegistrationService.getStudentById(id);
        SeniorOne seniorOne = new SeniorOne(studentRegistration.getId(),studentRegistration.getStudentFirstName(),
                studentRegistration.getStudentMidName(),studentRegistration.getStudentLastName(),studentRegistration.getStudentDateOfBirth()
        ,studentRegistration.getStudentNationalIdentificationNumberNIN(),studentRegistration.getStudentGender(),
                studentRegistration.getStudentClass(),studentRegistration.getFeesToBeePaid(),studentRegistration.getStudentHealthRecord()
        ,studentRegistration.getFormerSchoolName(),studentRegistration.getReasonWhyChangedSchool(),studentRegistration.getFormerSchoolPerformanceRecords()
        ,studentRegistration.getStudentPhoto(),studentRegistration.getStudentHomeAddress(),studentRegistration.getStudentSubCounty(),studentRegistration.getStudentDistrict());
        seniorOneService.saveToSeniorOne(seniorOne);
       selectedStudent.add(studentRegistration);
        return "redirect:/seniorOne";
    }


}
