package com.schools.school.controller;


import com.schools.school.entity.Teachers;
import com.schools.school.service.TeachersService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeacherController {
    private final TeachersService teachersService;

    public TeacherController(TeachersService teachersService) {
        this.teachersService = teachersService;
    }

    @GetMapping("/teacherForm")
    public String showTeachersForm(Model model) {
        model.addAttribute("teachers", new Teachers());
        return "teacher";
    }

    @PostMapping("/teach")
    public String saveTeacher(@ModelAttribute("teachers") Teachers teachers) {

        teachersService.saveTeacher(teachers);
        return "redirect:/teacher/list";
    }

    @RequestMapping("/teacher/list")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teachersService.getAllTeachers());
        return "teachers_list";
    }

    @RequestMapping("/teacher/update/{id}")
    public String updateTeachersRecords(@PathVariable("id") Long id, @ModelAttribute("teachers") Teachers teachers, Model model) {
        Teachers existingTeacher = teachersService.getTeacherById(id);
        // Update teacher attributes
        existingTeacher.setFirstName(teachers.getFirstName());
        existingTeacher.setMidName(teachers.getMidName());
        existingTeacher.setLastName(teachers.getLastName());
        existingTeacher.setDateOfBirth(teachers.getDateOfBirth());
        existingTeacher.setEmail(teachers.getEmail());
        existingTeacher.setPhoneNumber(teachers.getPhoneNumber());
        existingTeacher.setNationalIdentificationNumber(teachers.getNationalIdentificationNumber());

        teachersService.updateTeachers(existingTeacher);
        return "updated";
    }

    @RequestMapping("/teacher/salary")
    public String getTeachersSalary(Model model) {
        model.addAttribute("teachersSalary", teachersService.getAllTeachersSalary());
        return "list_salary";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeachersSalaryById(@PathVariable("id") Long id) throws TeacherNoFoundException {
        if(!teachersService.deleteTeachersById(id)){
            throw new TeacherNoFoundException(id);
        }
        teachersService.deleteTeachersById(id);
        return "redirect:/updated";
    }
}
