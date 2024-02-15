package com.schools.school.controller;


import com.schools.school.entity.Teachers;
import com.schools.school.service.TeachersService;
import org.springframework.data.repository.query.Param;
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
    public String listTeachers(Model model,@Param ("teach") String teach) {
        model.addAttribute("teachers", teachersService.getAllTeachers(teach));
        model.addAttribute("teach",teach);
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
//        model.addAttribute("Key",Key);
        return "list_salary";
    }
//    @GetMapping("/get/teacher/name")
//    public Teachers getTeachersName(@PathVariable String name){
//        if (teachersService == null){
//            throw new IllegalArgumentException("No name matches your search please "  + name);
//        }else {
//            return teachersService.getTeacherByName(name);
//        }
//    }
// this method is tested
    @RequestMapping("/teacher/delete/{id}")
    public String deleteTeachersSalaryById(@PathVariable("id") Long id)  {
        if (!teachersService.existById(id)){
            throw new IllegalArgumentException("Teacher does not exist");
        }
        teachersService.deleteTeachersById(id);
        return "success_delete";
    }
}
