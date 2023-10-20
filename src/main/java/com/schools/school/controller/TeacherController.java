package com.schools.school.controller;

import com.schools.school.entity.Teachers;
import com.schools.school.service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class TeacherController {
    private final TeachersService teachersService;

    public TeacherController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }
    @PostMapping("/api/save/teacher")
    public String saveTeacher(@ModelAttribute("teacher") Teachers teachers) {
        teachersService.saveTeacher(teachers);
        return "teacher";
    }

    public String listTeachers(Model model) {
        model.addAttribute("teachers", teachersService.getAllTeachers());
        return "teachers_list";
    }

    public String createNewTeacher(Model model) {
        Teachers teachers = new Teachers();
        model.addAttribute("teacher", teachers);
        return "new_teacher";
    }

    public String updateTeachersRecords(@PathVariable Long id, @ModelAttribute("teacher")
    Teachers teachers, Model model) {
        Teachers existingTeacher = teachersService.getTeacherById(id);
        existingTeacher.setId(id);
        existingTeacher.setFirstName(teachers.getFirstName());
        existingTeacher.setMidName(teachers.getMidName());
        existingTeacher.setLastName(teachers.getLastName());
        existingTeacher.setDateOfBirth(teachers.getDateOfBirth());
        existingTeacher.setEmail(teachers.getEmail());
        existingTeacher.setPhoneNumber(teachers.getPhoneNumber());
        existingTeacher.setNationalIdentificationNumber(teachers.getNationalIdentificationNumber());
//        existingTeacher.setTeachersSalary(teachers.getTeachersSalary());
//        existingTeacher.
        teachersService.updateTeachers(existingTeacher);
        return "updated";
    }

    public String getTeachersSalary() {
        teachersService.getAllTeachersSalary();
        return "list_salary";
    }

    public String deleteTeachersSalaryById(Long id) {
        teachersService.deleteTeachersById(id);
        return "redirect:/updated";
    }
}
