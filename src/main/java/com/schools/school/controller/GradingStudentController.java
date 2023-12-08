package com.schools.school.controller;

import com.schools.school.entity.GradingStudent;
import com.schools.school.service.GradingStudentService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;

@Controller
public class GradingStudentController {
    private final GradingStudentService gradingStudentService;

    @Autowired
    public GradingStudentController(GradingStudentService gradingStudentService) {
        this.gradingStudentService = gradingStudentService;
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
    // Add an exclusion for favicon.ico
    @GetMapping("/favicon.ico")
    public ResponseEntity<byte[]> favicon() throws IOException {
        ClassPathResource resource = new ClassPathResource("/static/favicon.ico");

        byte[] media = Files.readAllBytes(resource.getFile().toPath());

        HttpHeaders headers = new HttpHeaders();
        headers.setCacheControl(CacheControl.noCache().getHeaderValue());
        headers.setContentType(MediaType.parseMediaType("image/vnd.microsoft.icon"));

        return new ResponseEntity<>(media, headers, HttpStatus.OK);
    }

    @GetMapping("/total/marks")
    public String getTotalMark(Model model) {
        // Retrieve all students from the service
        List<GradingStudent> allStudents = gradingStudentService.getAllStudents();

         //Calculate grades for each student
        for (GradingStudent student : allStudents) {
            gradingStudentService.calculateGrade(student);
        }
        // Inside your controller method
//        for (GradingStudent student : allStudents) {
//            gradingStudentService.calculateGrade(student);
//            System.out.println("Student ID: " + student.getId() + ", Grade: " + student.getGrade());
//        }


        // Add the list of students to the model
        model.addAttribute("students", allStudents);

        return "mark_list";
    }


    @GetMapping("/{studentId}/total-marks")
    public String getTotalMarks(@PathVariable Long studentId, Model model) {
        GradingStudent student = gradingStudentService.findById(studentId);

        if (student != null) {
            gradingStudentService.getTotalMarks(student);
        } else {
            // Handle student not found
            model.addAttribute("error", "Student marks not found");
            return "error";
        }
        return "total";
    }

//    @GetMapping("/marks/grade")
//    public String getGrade(Model model) {
//        GradingStudent student = gradingStudentService.calculateGrade(new GradingStudent());
//        model.addAttribute("marks", student);
//        return "marks";
//    }

    @GetMapping("/{studentId}/chemistry-grade")
    public String getChemistryGrade(@PathVariable Long studentId, Model model) {
        GradingStudent student = gradingStudentService.findById(studentId);

        if (student != null) {
            gradingStudentService.calculateGrade(student);
            student.getChemistry();
        } else {
            // Handle student not found
            model.addAttribute("error", "Student not found");
            return "error";
        }
        return "chem";
    }

    @PostMapping("/save/update/{id}")
    public String updateStudentMark(@PathVariable Long id, @ModelAttribute("marks") GradingStudent gradingStudent) {
        GradingStudent existingMarks = gradingStudentService.findById(id);
        if (existingMarks != null) {
            existingMarks.setFrench(gradingStudent.getFrench());
            existingMarks.setCre(gradingStudent.getCre());
            existingMarks.setBios(gradingStudent.getBios());
            existingMarks.setEnglish(gradingStudent.getEnglish());
            existingMarks.setChemistry(gradingStudent.getChemistry());
            gradingStudentService.updateStudentMarks(existingMarks);
            return "marks_update_list";
        } else {
            // Handle student not found
            return "error";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteMarksById(@PathVariable Long id) {
        gradingStudentService.deleteMarksById(id);
        return "redirect:/marks_update_list";
    }
}
