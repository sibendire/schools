package com.schools.school.controller;

import com.schools.school.entity.ParentPortal;
import com.schools.school.entity.StudentRegistration;
import com.schools.school.service.ParentPortalService;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class ParentController {
    private final ParentPortalService parentPortalService;

    @GetMapping("/parentForm")
    public String showParentForm(Model model) {
        model.addAttribute("parents", new ParentPortal());
        return "parents";
    }

    @PostMapping("/saveParent")
    public String saveParentInformation(@ModelAttribute("parents") ParentPortal parentPortal) {
        parentPortalService.saveParent(parentPortal);
        return "redirect:/api/parent/list";

    }

    @RequestMapping("/api/parent/list")
    public String listParents(Model model,@Param("keyword") String Keyword) {
        model.addAttribute("parents", parentPortalService.getAllParents(Keyword));
        model.addAttribute("Keyword",Keyword);
        return "parent_list";
    }
//    @RequestMapping("/api/student/list")
//    public String listStudentRegistered(Model model, @Param("keyword") String keyword) {
//        List<ParentPortal> parents = studentRegistrationService.getAllStudents(keyword);
//        model.addAttribute("parents", parents);
//        model.addAttribute("keyword",keyword);
//        return "student_List";
//    }

    @RequestMapping("/update/parent/{id}")
    public String editParentRecord(@PathVariable("id") Long id, Model model) {
        ParentPortal parentPortal = parentPortalService.getParentById(id);
        model.addAttribute("parents", parentPortal);
        return "update_parent";
    }
    @RequestMapping("/deleteParent/{id}")
    public String deleteParent(@PathVariable("id")Long id){

        parentPortalService.deleteParentById(id);
        return "delete_success";
    }

}
