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

    // this method is tested
    @GetMapping("/teacherForm")
    public String showTeachersForm(Model model) {
        model.addAttribute("teachers", new Teachers());
        return "teacher";
    }

    // this method is tested
    @PostMapping("/teach")
    public String saveTeacher(@ModelAttribute("teachers") Teachers teachers) {

        teachersService.saveTeacher(teachers);
        return "redirect:/teacher/list";
    }

    // this method is tested
    @RequestMapping("/teacher/list")
    public String listTeachers(Model model) {
        model.addAttribute("teachers", teachersService.getAllTeachers());
        return "teachers_list";
    }

    // this method is tested
    @RequestMapping("/teacher/update/{id}")
    public String updateTeachersRecords(@PathVariable("id") Long id, Model model) {
        Teachers teachers = teachersService.getTeacherById(id);
        model.addAttribute("teachers", teachers);
        return "update_teacher";
    }

    @RequestMapping("/teacher/salary")
    public String getTeachersSalary(Model model) {
        model.addAttribute("teachersSalary", teachersService.getAllTeachersSalary());
        return "list_salary";
    }

    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeachersSalaryById(@PathVariable("id") Long id)  {
        teachersService.deleteTeachersById(id);
        return "success_delete";
    }
}
